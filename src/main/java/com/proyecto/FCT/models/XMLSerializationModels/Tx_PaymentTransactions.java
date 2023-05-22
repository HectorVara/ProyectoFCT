package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="Tx_PaymentTransactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tx_PaymentTransactions {
    @XmlElement(name = "Tx_Payment")
    private List<Tx_Payment> txPayment;

    public Tx_PaymentTransactions() {

    }

    public Tx_PaymentTransactions(List<Tx_Payment> txPayment) {
        this.txPayment = txPayment;
    }

    public List<Tx_Payment> getTxPayment() {
        return txPayment;
    }

    public void setTxPayment(List<Tx_Payment> txPayment) {
        this.txPayment = txPayment;
    }
}
