package com.proyecto.FCT.utils;

import com.proyecto.FCT.models.parseModels.Transaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLParser {
    private JAXBContext jaxbContext = null;

    public Transaction parseXML(String ruta) throws JAXBException {
        //Se parsea la clase Transaction, que hace referencia al objto padre del XML y a partir de éste
        //se va accediendo a las capas inferiores(Data --> Document)
        jaxbContext = JAXBContext.newInstance(Transaction.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File file = new File(ruta);
        Transaction t = (Transaction) jaxbUnmarshaller.unmarshal(file);
        return t;
    }
}
