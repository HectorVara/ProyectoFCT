package com.proyecto.FCT.models.persistenceModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="payment_id")
    private long payment_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Document document;
    @Column(name = "lineNumber")
    private String lineNumber;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "unitAmount")
    private String unitAmount;
    @Column(name = "sign")
    private String sign;
    @Column(name = "changes")
    private String change;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_media_id", referencedColumnName = "id")
    private PaymentMedia paymentMedia;


    public Payment() {
    }

    public Payment(long payment_id, Document document, String lineNumber, String quantity, String unitAmount, String sign, String change, PaymentMedia paymentMedia) {
        this.payment_id = payment_id;
        this.document = document;
        this.lineNumber = lineNumber;
        this.quantity = quantity;
        this.unitAmount = unitAmount;
        this.sign = sign;
        this.change = change;
        this.paymentMedia = paymentMedia;
    }

    public Payment(Document document, String lineNumber, String quantity, String unitAmount, String sign, String change, PaymentMedia paymentMedia) {
        this.document = document;
        this.lineNumber = lineNumber;
        this.quantity = quantity;
        this.unitAmount = unitAmount;
        this.sign = sign;
        this.change = change;
        this.paymentMedia = paymentMedia;
    }

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(String unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public PaymentMedia getPaymentMedia() {
        return paymentMedia;
    }

    public void setPaymentMedia(PaymentMedia paymentMedia) {
        this.paymentMedia = paymentMedia;
    }
}

