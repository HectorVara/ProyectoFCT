package com.proyecto.FCT.models.parseModels;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="ListDocumentPayment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDocumentPayment {
    @XmlElement(name="DocumentPayment")
    private List<Payment> payments;

    public ListDocumentPayment(List<Payment> payments) {
        this.payments = payments;
    }

    public ListDocumentPayment() {
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
