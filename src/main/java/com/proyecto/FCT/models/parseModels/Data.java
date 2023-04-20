package com.proyecto.FCT.models.parseModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
