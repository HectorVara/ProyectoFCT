package com.proyecto.FCT.models.parseModels;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement(name="Document")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {

    @XmlElement(name = "Uid")
    private String uid;
    @XmlElement(name = "IdStore")
    private String idStore;
    @XmlElement(name = "IdWorkstation")
    private String idWorkstation;
    @XmlElement(name = "SessionDate")
    private Date sessionDate;
    @XmlElement(name = "Date")
    private Date date;
    @XmlElement(name = "OperationNumber")
    private String operationNumber;
    @XmlElement(name = "IdDocumentType")
    private String idDocumentType;
    @XmlElement(name = "IdOperator")
    private String idOperator;
    @XmlElement(name = "ListDocumentLine")
    private ListDocumentLine lines;
    @XmlElement(name = "ListDocumentPayment")
    private ListDocumentPayment payments;



    public Document() {
    }

    public Document(String uid, String idStore, String idWorkstation, Date sessionDate, Date date, String operationNumber, String idDocumentType, String idOperator,ListDocumentLine lines, ListDocumentPayment payments) {
        this.uid = uid;
        this.idStore = idStore;
        this.idWorkstation = idWorkstation;
        this.sessionDate = sessionDate;
        this.date = date;
        this.operationNumber = operationNumber;
        this.idDocumentType = idDocumentType;
        this.idOperator = idOperator;
        this.lines = lines;
        this.payments = payments;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIdStore() {
        return idStore;
    }

    public void setIdStore(String idStore) {
        this.idStore = idStore;
    }

    public String getIdWorkstation() {
        return idWorkstation;
    }

    public void setIdWorkstation(String idWorkstation) {
        this.idWorkstation = idWorkstation;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(String idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public String getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public ListDocumentLine getLines() {
        return lines;
    }

    public void setLines(ListDocumentLine lines) {
        this.lines = lines;
    }

    public ListDocumentPayment getPayments() {
        return payments;
    }

    public void setPayments(ListDocumentPayment payments) {
        this.payments = payments;
    }
}