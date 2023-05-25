package com.proyecto.FCT.models.parseModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="ListDocumentPrintBuffer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDocumentPrintBuffer {
    @XmlElement(name="DocumentPrintBuffer")
    private List<DocumentPrintBuffer> documentPrintBuffers;

    public ListDocumentPrintBuffer(List<DocumentPrintBuffer> documentPrintBuffers) {
        this.documentPrintBuffers = documentPrintBuffers;
    }

    public ListDocumentPrintBuffer() {
    }

    public List<DocumentPrintBuffer> getDocumentPrintBuffers() {
        return documentPrintBuffers;
    }

    public void setDocumentPrintBuffers(List<DocumentPrintBuffer> documentPrintBuffers) {
        this.documentPrintBuffers = documentPrintBuffers;
    }
}
