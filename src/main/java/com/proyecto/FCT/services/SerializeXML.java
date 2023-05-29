package com.proyecto.FCT.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.proyecto.FCT.models.XMLSerializationModels.Transactions;
import com.proyecto.FCT.models.queryModels.ICharges;
import com.proyecto.FCT.models.queryModels.IPayments;
import com.proyecto.FCT.models.queryModels.ISales;
import com.proyecto.FCT.repositories.DocumentRepository;
import com.proyecto.FCT.utils.ExcelWriter;
import com.proyecto.FCT.utils.TransactionsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SerializeXML {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    TransactionsAdapter adapter;
    @Autowired
    ExcelWriter excelWriter;

    public Transactions serialize(String idStore, String date) throws IOException {

        List<IPayments> payments = documentRepository.payments(idStore,date);
        List<ICharges> cobros = documentRepository.cobros(idStore,date);
        List<ISales> sales = documentRepository.sales(idStore, date);
        Double totalCobros = documentRepository.totalCobros(idStore, date);
        Double totalPayments = documentRepository.totalPayments(idStore, date);
        Transactions t =  adapter.adaptTransactions(sales,cobros,payments,totalPayments,totalCobros,idStore,date);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("src\\main\\resources\\reports\\xml\\"+idStore+date+".xml"), t);
        File file = new File("src\\main\\resources\\reports\\xml\\"+idStore+date+".xml");
        excelWriter.writeExcel(t);
        return t;

    }

}
