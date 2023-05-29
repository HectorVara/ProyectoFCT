package com.proyecto.FCT.utils;

import com.proyecto.FCT.models.XMLSerializationModels.*;
import com.proyecto.FCT.models.queryModels.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsAdapter {

    public Transactions adaptTransactions(List<ISales> iSaleType, List<ICharges> iCobros, List<IPayments> iPayments, double totalPayments, double totalCobros, String idStore, String date){

        Transactions t = new Transactions();
        t.setMetadata(new Metadata(idStore,date));
        Tx_SalesNumberTransactions txSalesNumberTransactions = new Tx_SalesNumberTransactions();
        List<Tx_SalesNumber> txSalesNumbers= new ArrayList<>();
        Tx_ProductTypeTransactions txProductTypeTransactions = new Tx_ProductTypeTransactions();
        List<Tx_ProductType> productTypes = new ArrayList<>();
        Tx_PaymentTransactions txPaymentTransactions = new Tx_PaymentTransactions();
        List<Tx_Payment> txPayments = new ArrayList<>();
        for(int i=0; i<iSaleType.size();i++){
            Tx_SalesNumber salesNumber=new Tx_SalesNumber();
            salesNumber.setDocumentType( Integer.toString(iSaleType.get(i).getId()));
            salesNumber.setDescription(iSaleType.get(i).getDescription());
            salesNumber.setNumberDocs( Integer.toString(iSaleType.get(i).getTotal()));
            salesNumber.setTx_Code(('1'+padLeftZeros(iSaleType.get(i).getId(),6)));
            txSalesNumbers.add(salesNumber);
        }
        txSalesNumberTransactions.setTxSalesNumbers(txSalesNumbers);
        t.setTxSalesNumberTransactions(txSalesNumberTransactions);
        for(int i=0;i<iCobros.size();i++){
            Tx_ProductType txProductType = new Tx_ProductType();
            txProductType.setProductType( Integer.toString(iCobros.get(i).getId()));
            txProductType.setDescription(iCobros.get(i).getDescription());
            txProductType.setAmount(Double.toString(iCobros.get(i).getTotal()));
            txProductType.setTx_Code('2'+padLeftZeros(iCobros.get(i).getId(),6));
            productTypes.add(txProductType);
        }
        txProductTypeTransactions.setTxProductTypes(productTypes);
        t.setTxProductTypeTransactions(txProductTypeTransactions);
        for(int i=0;i<iPayments.size();i++){
            Tx_Payment txPayment = new Tx_Payment();
            txPayment.setPaymentMedia(Integer.toString(iPayments.get(i).getId()));
            txPayment.setDescription(iPayments.get(i).getDescription());
            txPayment.setAmount(Double.toString(iPayments.get(i).getTotal()));
            txPayment.setTx_Code('3'+padLeftZeros(iPayments.get(i).getId(),6));
            txPayments.add(txPayment);
        }
        txPaymentTransactions.setTxPayment(txPayments);
        t.setTxPaymentTransactions(txPaymentTransactions);

        t.setTotalPayments(totalPayments);
        t.setTotalSales(totalCobros);
        t.setDifference(totalCobros-totalPayments);

        return t;
    }

    //Éste método es para añadir ceros a la izquierda al Tx_Code hasta que tenga longitud 6
    public String padLeftZeros(int inputStringInt, int length) {
        String inputString = Integer.toString(inputStringInt);
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}

