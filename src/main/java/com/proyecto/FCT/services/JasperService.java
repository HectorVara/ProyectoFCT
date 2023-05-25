package com.proyecto.FCT.services;

import com.proyecto.FCT.models.jasperModels.Ticket;
import com.proyecto.FCT.repositories.DocumentRepository;
import net.sf.jasperreports.engine.*;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class JasperService {
    @Autowired
    Base64Decoder decoder;
    @Autowired
    DocumentRepository documentRepository;

    public byte[] createJasperReport(long id) throws JRException {
        Map params = new HashMap();
        List<String> encodedPrintBuffer = documentRepository.getEncodedData(id);
        List<String> decodedPrintBuffer = decoder.getDataString(encodedPrintBuffer);
        Ticket ticket = getTicket(decodedPrintBuffer);
        String logoPath = getLogo(ticket.getHeader());

        params.put("body", ticket.getBody());
        params.put("col_footer",ticket.getCol_footer());
        params.put("footer", ticket.getFooter());
        params.put("summary", ticket.getSummary());
        params.put("logo", logoPath);

        JasperCompileManager.compileReportToFile("src\\main\\resources\\jasper\\templates\\ticket1.jrxml", "src\\main\\resources\\jasper\\tmp\\ticket1.jasper");
        JasperFillManager.fillReportToFile("src\\main\\resources\\jasper\\tmp\\ticket1.jasper", params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile("src\\main\\resources\\jasper\\tmp\\ticket1.jrprint", "src\\main\\resources\\jasper\\reports\\ticket1.pdf");


        return getPdfToBytes();
    }
    //Este método forma el objeto ticket. Según las etiquetas que contiene cada linea vamos identificando las partes
    //del ticket y las metemos en su atributo correspondiente.
    public Ticket getTicket(List<String> decodedPrintBuffer) {
        Ticket ticket = new Ticket();
        String header = "";
        String body = "";
        String col_footer="";
        String footer = "";
        String summary = "";
        String base64String = "";
        List<String> lines = new ArrayList<>();
        //Por ahora solo hacemos la conversión del primer elemento de la lista. Creamos una lista de las lineas del ticket ya decodificadas
        decodedPrintBuffer.get(0).lines().forEach(s -> lines.add(s));


        for (int i = 0; i < lines.size(); i++) {

            if ((lines.get(i).contains("<span attr=\"j\"") && i < 3) || lines.get(i).contains("<info width") || lines.get(i).contains("<placeholder")) {
                if(lines.get(i).contains("<logo>"))
                    i++;
                header += removeTags(lines.get(i)) + "\n";
            } else if (lines.get(i).contains("<logo>base64")) {
                base64String += removeTags(lines.get(i));

            }else if(lines.get(i).contains("<span attr=\"j\"") || lines.get(i).contains("<span attr=\"e\"")){
                col_footer += removeTagsButNoSpaces(lines.get(i));

            }else if (lines.get(i).contains("<barcode type=\"QRCODE\" ")) {
                i++;
                do {
                    summary += lines.get(i) + "\n";
                    i++;

                } while (i<lines.size());

            }else if(lines.get(i).contains("<span attr=\"b\"")) {
                footer += removeTagsButNoSpaces(lines.get(i)) +"\n";
            }else if(lines.get(i).contains("<logo>base64")){
                i++;
            } else if (!lines.get(i).contains("<")){
                body += lines.get(i) +"\n";
            }
        }


        ticket.setHeader(header);
        ticket.setBody(body);
        ticket.setCol_footer(col_footer);
        ticket.setFooter(footer);
        ticket.setSummary(summary);

     /*   System.out.println("-------------------HEADER---------------\n" + header);
        System.out.println("-----------------BODY----------------\n" + body);
        System.out.println("-----------------COL-FOOTER----------------\n"+col_footer);
        System.out.println("-----------------FOOTER----------------\n" + footer);
        System.out.println("-----------------SUMMARY----------------\n" + summary);*/

        return ticket;
    }
    //El método removeTags elimina las etiquetas utilizando la librería Jsoup, pero también me eliminaba los espacios
    public String removeTags(String html){
        return Jsoup.parse(html).text();
    }
    //Con el siguiente método elimino las etiquetas pero dejo los espacios
    public String removeTagsButNoSpaces(String line){
        String newLine="";
        for(int i=0;i<line.length();i++){
            if(line.charAt(i) == '<'){
                do {
                    i++;
                }while(line.charAt(i)!='>');

            }
            if(line.charAt(i)!='>')
                newLine += line.charAt(i);
        }
        return newLine;
    }
    //Convierte el PDF en bytes para enviarlo al frontend
    public byte[] getPdfToBytes(){
        Path pdfPath = Paths.get("src\\main\\resources\\jasper\\reports\\ticket1.pdf");
        byte[] pdf=null;
        try {
            pdf = Files.readAllBytes(pdfPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pdf;
    }
    //En este caso solo tenemos dos logos, dependiendo lo que venga en el header del ticket elegimos uno u otro
    public String getLogo(String header){
        String logoPath = "\\src\\main\\resources\\jasper\\images";

        header = header.toUpperCase();

        if(header.contains("ZARA HOME"))
            logoPath += "\\zarahome.jpg";
        else logoPath += "\\zara.png";

        return logoPath;

    }
}
