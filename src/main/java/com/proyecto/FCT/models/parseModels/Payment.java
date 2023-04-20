package com.proyecto.FCT.models.parseModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DocumentPayment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {

    @XmlElement(name = "LineNumber")
    private String lineNumber;
    @XmlElement(name = "Quantity")
    private String quantity;
    @XmlElement(name = "UnitAmount")
    private String unitAmount;
    @XmlElement(name = "Sign")
    private String sign;
    @XmlElement(name = "Change")
    private String change;
    @XmlElement(name = "IdMedia")
    private String idMedia;




    public Payment() {
    }

    public Payment(String lineNumber, String quantity, String unitAmount, String sign, String change, String idMedia) {
        this.lineNumber = lineNumber;
        this.quantity = quantity;
        this.unitAmount = unitAmount;
        this.sign = sign;
        this.change = change;
        this.idMedia = idMedia;
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

    public String getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }


}
