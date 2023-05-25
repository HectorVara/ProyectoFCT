package com.proyecto.FCT.services;

import jakarta.xml.bind.DatatypeConverter;
import jakarta.xml.bind.JAXBContext;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Base64Decoder {
    private JAXBContext jaxbContext = null;
    public List<String> getDataString(List<String> datas){
        List<String> decodes= new ArrayList<>();
        String decodedText = "";
        byte[] decodedTextBytes = null;

        for(int i = 0; i < datas.size();i++){

            decodedTextBytes = DatatypeConverter.parseBase64Binary(datas.get(i));
            try {
                decodedText = new String(decodedTextBytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            decodes.add(decodedText);
            System.out.println(decodes.get(i));
        }

        return decodes;
    }
}

