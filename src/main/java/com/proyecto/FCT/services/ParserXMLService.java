package com.proyecto.FCT.services;

import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.models.parseModels.Transaction;
import com.proyecto.FCT.repositories.DocumentRepository;
import com.proyecto.FCT.utils.DocumentAdapter;
import com.proyecto.FCT.utils.XMLParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ParserXMLService {
    @Autowired
    DocumentRepository documentRepository;
    private final String path= "C:\\XML";
    DocumentAdapter adapter= new DocumentAdapter();
    public Document parseXMLandSave(String filename){
        String ruta = path + "\\" + filename;
        //XMLParser es una clase que parsea un XML y está en utils
        XMLParser parser = new XMLParser();
        Transaction t = new Transaction();
        try {
            t = parser.parseXML(ruta);
        } catch (JAXBException e) {
           e.printStackTrace();
        }
        com.proyecto.FCT.models.persistenceModels.Document d= adapter.adaptDocument(t);
        System.out.println("Guardando archivo "+filename);

        documentRepository.save(d);
        return t.getData().getDocument();

    }

}
