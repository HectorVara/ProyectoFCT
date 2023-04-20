package com.proyecto.FCT.models.parseModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
