package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Transactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transactions {
    @XmlElement(name="Metadata")
    private Metadata metadata;
    @XmlElement(name="Tx_SalesNumberTransactions")
    private Tx_SalesNumberTransactions txSalesNumberTransactions;
    @XmlElement(name="Tx_ProductTypeTransactions")
    private Tx_ProductTypeTransactions txProductTypeTransactions;
    @XmlElement(name="Tx_PaymentTransactions")
    private Tx_PaymentTransactions txPaymentTransactions;
    @XmlElement(name="Total_Sales")
    private double totalSales;
    @XmlElement(name="Total_Payments")
    private double totalPayments;
    @XmlElement(name="Difference")
    private double difference;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Tx_SalesNumberTransactions getTxSalesNumberTransactions() {
        return txSalesNumberTransactions;
    }

    public void setTxSalesNumberTransactions(Tx_SalesNumberTransactions txSalesNumberTransactions) {
        this.txSalesNumberTransactions = txSalesNumberTransactions;
    }

    public Tx_ProductTypeTransactions getTxProductTypeTransactions() {
        return txProductTypeTransactions;
    }

    public void setTxProductTypeTransactions(Tx_ProductTypeTransactions txProductTypeTransactions) {
        this.txProductTypeTransactions = txProductTypeTransactions;
    }

    public Tx_PaymentTransactions getTxPaymentTransactions() {
        return txPaymentTransactions;
    }

    public void setTxPaymentTransactions(Tx_PaymentTransactions txPaymentTransactions) {
        this.txPaymentTransactions = txPaymentTransactions;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }
}

