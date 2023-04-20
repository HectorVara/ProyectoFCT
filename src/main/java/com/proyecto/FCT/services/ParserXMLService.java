package com.proyecto.FCT.services;

import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.models.parseModels.Transaction;
import com.proyecto.FCT.utils.XMLParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;



@Service
public class ParserXMLService {
    private final String path= "C:\\XML2";
    public Document parseXML(String filename){
        String ruta = path + "\\" + filename;
        //XMLParser es una clase que parsea un XML y está en utils
        XMLParser parser = new XMLParser();
        Transaction t = new Transaction();
        try {
            t = parser.parseXML(ruta);
        } catch (JAXBException e) {
           e.printStackTrace();
        }
        return t.getData().getDocument();

    }

}
