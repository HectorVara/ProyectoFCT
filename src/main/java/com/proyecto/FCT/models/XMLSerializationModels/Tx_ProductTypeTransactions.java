package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="Tx_ProductTypeTransactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tx_ProductTypeTransactions {
    @XmlElement(name = "Tx_ProductType")
    private List<Tx_ProductType> txProductTypes;

    public Tx_ProductTypeTransactions(List<Tx_ProductType> txProductTypes) {
        this.txProductTypes = txProductTypes;
    }

    public Tx_ProductTypeTransactions() {
    }

    public List<Tx_ProductType> getTxProductTypes() {
        return txProductTypes;
    }

    public void setTxProductTypes(List<Tx_ProductType> txProductTypes) {
        this.txProductTypes = txProductTypes;
    }
}
