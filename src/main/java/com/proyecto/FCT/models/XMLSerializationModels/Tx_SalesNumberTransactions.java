package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="Tx_SalesNumberTransactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tx_SalesNumberTransactions {
    @XmlElement(name="Tx_SalesNumber")
    private List<Tx_SalesNumber> txSalesNumbers;

    public Tx_SalesNumberTransactions() {

    }

    public List<Tx_SalesNumber> getTxSalesNumbers() {
        return txSalesNumbers;
    }

    public void setTxSalesNumbers(List<Tx_SalesNumber> txSalesNumbers) {
        this.txSalesNumbers = txSalesNumbers;
    }

    public Tx_SalesNumberTransactions(List<Tx_SalesNumber> txSalesNumbers) {
        this.txSalesNumbers = txSalesNumbers;
    }
}
