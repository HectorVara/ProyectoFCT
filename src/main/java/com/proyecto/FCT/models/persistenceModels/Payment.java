package com.proyecto.FCT.models.persistenceModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="payment_id")
    private long payment_id;
    @ManyToOne(cascade = CascadeType.ALL, optional = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;
    @Column(name="lineNumber")
    private String lineNumber;
    @Column(name="quantity")
    private String quantity;
    @Column(name="unitAmount")
    private String unitAmount;
    @Column(name="sign")
    private String sign;
    @Column(name="changes")
    private String change;
    @Column(name="idMedia")
    private String idMedia;

    public Payment(long payment_id, Document document, String lineNumber, String quantity, String unitAmount, String sign, String change, String idMedia) {
        this.payment_id = payment_id;
        this.document = document;
        this.lineNumber = lineNumber;
        this.quantity = quantity;
        this.unitAmount = unitAmount;
        this.sign = sign;
        this.change = change;
        this.idMedia = idMedia;
    }

    public Payment(Document document, String lineNumber, String quantity, String unitAmount, String sign, String change, String idMedia) {
        this.document = document;
        this.lineNumber = lineNumber;
        this.quantity = quantity;
        this.unitAmount = unitAmount;
        this.sign = sign;
        this.change = change;
        this.idMedia = idMedia;
    }

    public Payment() {
    }

    public void setPaymentId(long payment_id) {
        this.payment_id = payment_id;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setUnitAmount(String unitAmount) {
        this.unitAmount = unitAmount;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }

    public long getPaymentId() {
        return payment_id;
    }

    public Document getDocument() {
        return document;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnitAmount() {
        return unitAmount;
    }

    public String getSign() {
        return sign;
    }

    public String getChange() {
        return change;
    }

    public String getIdMedia() {
        return idMedia;
    }
}

