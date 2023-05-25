package com.proyecto.FCT.utils;

import com.proyecto.FCT.models.parseModels.Transaction;
import com.proyecto.FCT.models.persistenceModels.*;

import java.util.ArrayList;
import java.util.List;

public class DocumentAdapter {

    public Document adaptDocument(Transaction t){
        //Los atributos propios del Document se le pasan por constructor
        Document d= new Document(t.getData().getDocument().getUid(),t.getData().getDocument().getIdStore(),t.getData().getDocument().getIdWorkstation(),t.getData().getDocument().getSessionDate(),
                t.getData().getDocument().getDate(),t.getData().getDocument().getOperationNumber(),new DocumentType(Integer.parseInt(t.getData().getDocument().getIdDocumentType())),t.getData().getDocument().getIdOperator());

        //Para transferir las listas es necesario recorrerlas y pasar los datos de cada atributo usando getters y setters
        List<Line> lines= new ArrayList<>();
        List<Payment> payments= new ArrayList<>();
        List<EncodedData> encodedData = new ArrayList<>();
        if(t.getData().getDocument().getLines()!=null) {

            for (int i = 0; i < t.getData().getDocument().getLines().getLines().size(); i++) {
                Line line = new Line();
                line.setLineNumber(t.getData().getDocument().getLines().getLines().get(i).getLineNumber());
                line.setCode(t.getData().getDocument().getLines().getLines().get(i).getCode());
                line.setColor(t.getData().getDocument().getLines().getLines().get(i).getModel());
                line.setModel(t.getData().getDocument().getLines().getLines().get(i).getModel());
                line.setQuality(t.getData().getDocument().getLines().getLines().get(i).getQuality());
                line.setSize(t.getData().getDocument().getLines().getLines().get(i).getSize());
                //line.setIdProductType(t.getData().getDocument().getLines().getLines().get(i).getIdProductType());
                line.setTotalGross(t.getData().getDocument().getLines().getLines().get(i).getTotalGross());
                line.setUnitInputPrice(t.getData().getDocument().getLines().getLines().get(i).getUnitInputPrice());
                line.setUnitMasterPrice(t.getData().getDocument().getLines().getLines().get(i).getUnitMasterPrice());
                line.setUnitGross(t.getData().getDocument().getLines().getLines().get(i).getUnitGross());
                line.setUnitOriginalPrice(t.getData().getDocument().getLines().getLines().get(i).getUnitOriginalPrice());
                line.setQuantity(t.getData().getDocument().getLines().getLines().get(i).getQuantity());
                line.setSign(t.getData().getDocument().getLines().getLines().get(i).getSign());
                line.setSignVoid(t.getData().getDocument().getLines().getLines().get(i).getSignVoid());
                line.setDescription(t.getData().getDocument().getLines().getLines().get(i).getDescription());
                line.setProductType(new ProductType(Integer.parseInt(t.getData().getDocument().getLines().getLines().get(i).getIdProductType())));
                line.setDocument(d);

                lines.add(line);
            }
            d.setLines(lines);

        }


        if(t.getData().getDocument().getPayments()!=null) {

            for (int i = 0; i < t.getData().getDocument().getPayments().getPayments().size(); i++) {
                Payment p = new Payment();
                p.setChange(t.getData().getDocument().getPayments().getPayments().get(i).getChange());
                p.setLineNumber(t.getData().getDocument().getPayments().getPayments().get(i).getLineNumber());
                p.setQuantity(t.getData().getDocument().getPayments().getPayments().get(i).getQuantity());
                //p.setIdMedia(t.getData().getDocument().getPayments().getPayments().get(i).getIdMedia());
                p.setSign(t.getData().getDocument().getPayments().getPayments().get(i).getSign());
                p.setUnitAmount(t.getData().getDocument().getPayments().getPayments().get(i).getUnitAmount());
                p.setPaymentMedia(new PaymentMedia(Integer.parseInt(t.getData().getDocument().getPayments().getPayments().get(i).getIdMedia())));
                p.setDocument(d);
                payments.add(p);

            }
            d.setPayments(payments);

        }
        if(t.getData().getDocument().getPrintBuffer()!=null){
            for (int i=0;i<t.getData().getDocument().getPrintBuffer().getDocumentPrintBuffers().size();i++){
                EncodedData ed = new EncodedData();
                ed.setData(t.getData().getDocument().getPrintBuffer().getDocumentPrintBuffers().get(i).getData());
                ed.setDocument(d);
                encodedData.add(ed);
            }
            d.setEncodedData(encodedData);
        }


        return d;
    }
}

