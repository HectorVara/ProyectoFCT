package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Tx_Payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tx_Payment {
    @XmlElement(name = "PaymentMedia")
    private String PaymentMedia;
    @XmlElement(name="Description")
    private String Description;
    @XmlElement(name="Amount")
    private String Amount;
    @XmlElement(name="Tx_Code")
    private String Tx_Code;

    public Tx_Payment() {

    }

    public String getPaymentMedia() {
        return PaymentMedia;
    }

    public void setPaymentMedia(String paymentMedia) {
        PaymentMedia = paymentMedia;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getTx_Code() {
        return Tx_Code;
    }

    public void setTx_Code(String tx_Code) {
        Tx_Code = tx_Code;
    }

    public Tx_Payment(String paymentMedia, String description, String amount, String tx_Code) {
        PaymentMedia = paymentMedia;
        Description = description;
        Amount = amount;
        Tx_Code = tx_Code;
    }
}
