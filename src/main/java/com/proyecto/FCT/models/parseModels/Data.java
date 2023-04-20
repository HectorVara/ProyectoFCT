package com.proyecto.FCT.models.parseModels;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    @XmlElement(name="Document")
    private Document document;


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
