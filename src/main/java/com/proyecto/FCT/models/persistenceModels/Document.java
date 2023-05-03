package com.proyecto.FCT.models.persistenceModels;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="documents")
public class Document {
    //Id, Uid, IdStore, IdWorkstation, SessionDate, Date, OperationNumber, IdDocumentType, IdOperator
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="uid")
    private String uid;
    @Column(name="idStore")
    private String idStore;
    @Column(name="idWorkstation")
    private String idWorkstation;
    @Column(name="sessionDate")
    private Date sessionDate;
    @Column(name="date")
    private Date date;
    @Column(name="operationNumber")
    private String operationNumber;

    @Column(name="idOperator")
    private String idOperator;

    @OneToMany(mappedBy = "document",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Line> lines;

    @OneToMany(mappedBy = "document",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Payment> payments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="document_type_id", referencedColumnName = "id")
    private DocumentType documentType;


    public Document(long id, String uid, String idStore, String idWorkstation, Date sessionDate, Date date, String operationNumber, DocumentType documentType, String idOperator) {
        this.id = id;
        this.uid = uid;
        this.idStore = idStore;
        this.idWorkstation = idWorkstation;
        this.sessionDate = sessionDate;
        this.date = date;
        this.operationNumber = operationNumber;
        this.documentType = documentType;
        this.idOperator = idOperator;

    }

    public Document(String uid, String idStore, String idWorkstation, Date sessionDate, Date date, String operationNumber,DocumentType documentType, String idOperator) {
        this.uid = uid;
        this.idStore = idStore;
        this.idWorkstation = idWorkstation;
        this.sessionDate = sessionDate;
        this.date = date;
        this.operationNumber = operationNumber;
        this.documentType = documentType;
        this.idOperator = idOperator;

    }

    public Document(String uid, String idStore, String idWorkstation, Date sessionDate, Date date, String operationNumber, DocumentType documentType, String idOperator, List<Line> lines,List<Payment> payments) {
        this.uid = uid;
        this.idStore = idStore;
        this.idWorkstation = idWorkstation;
        this.sessionDate = sessionDate;
        this.date = date;
        this.operationNumber = operationNumber;
        this.documentType = documentType;
        this.idOperator = idOperator;
        this.lines = lines;
        this.payments = payments;
    }

    public Document() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

   /* public String getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(String idDocumentType) {
        this.idDocumentType = idDocumentType;
    }*/

    public String getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }


    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
