package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Tx_SalesNumber")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tx_SalesNumber {
    @XmlElement(name="DocumentType")
    private String DocumentType;
    @XmlElement(name="Description")
    private String Description;
    @XmlElement(name="NumberDocs")
    private String NumberDocs;
    @XmlElement(name="Tx_Code")
    private String Tx_Code;

    public Tx_SalesNumber() {

    }

    public String getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNumberDocs() {
        return NumberDocs;
    }

    public void setNumberDocs(String numberDocs) {
        NumberDocs = numberDocs;
    }

    public String getTx_Code() {
        return Tx_Code;
    }

    public void setTx_Code(String tx_Code) {
        Tx_Code = tx_Code;
    }

    public Tx_SalesNumber(String documentType, String description, String numberDocs, String tx_Code) {
        DocumentType = documentType;
        Description = description;
        NumberDocs = numberDocs;
        Tx_Code = tx_Code;
    }
}
