package com.proyecto.FCT.utils;

import com.proyecto.FCT.models.XMLSerializationModels.Transactions;
import com.proyecto.FCT.models.XMLSerializationModels.Tx_Payment;
import com.proyecto.FCT.models.XMLSerializationModels.Tx_ProductType;
import com.proyecto.FCT.models.XMLSerializationModels.Tx_SalesNumber;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ExcelWriter {



    public void writeExcel(Transactions transactions) throws IOException {
        String excelFilePath = "src\\main\\resources\\reports\\excel\\"+ transactions.getMetadata().getIdStore()+ transactions.getMetadata().getSessionDate()+".xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        Row header = sheet.createRow(4);
        Cell headerCell = header.createCell(4);
        headerCell.setCellValue("Tienda");
        headerCell.setCellStyle(headerStyle);
        headerCell = header.createCell(5);
        headerCell.setCellValue(transactions.getMetadata().getIdStore());
        Row row = sheet.createRow(5);
        Cell cell = row.createCell(4);
        cell.setCellValue("Fecha");
        cell.setCellStyle(headerStyle);
        cell = row.createCell(5);
        cell.setCellValue(transactions.getMetadata().getSessionDate());
        List<String> headers = Arrays.asList("Código", "Número docs","Cobros","Pagos");
        int rowHeaders = 3;
        int rowStart = 7;
        double totalCobros = 0;
        double totalPayments = 0;

        row = sheet.createRow(rowStart);
        for(String head : headers){
            cell = row.createCell(++rowHeaders);
            cell.setCellValue(head);
            cell.setCellStyle(headerStyle);
        }

        for(int i = 0; i <transactions.getTxSalesNumberTransactions().getTxSalesNumbers().size(); i++){
            rowStart++;
            row = sheet.createRow(rowStart);
            writeSales(transactions.getTxSalesNumberTransactions().getTxSalesNumbers().get(i), row, style);
        }

        for(int i = 0; i < transactions.getTxProductTypeTransactions().getTxProductTypes().size(); i++){
            rowStart++;
            row = sheet.createRow(rowStart);
            totalCobros += writeCobros(transactions.getTxProductTypeTransactions().getTxProductTypes().get(i), row, style);
        }

        for(int i = 0; i < transactions.getTxPaymentTransactions().getTxPayment().size(); i++){
            rowStart++;
            row = sheet.createRow(rowStart);
            totalPayments += writePayments(transactions.getTxPaymentTransactions().getTxPayment().get(i), row, style);
        }
        rowStart++;
        row = sheet.createRow(rowStart);
        cell = row.createCell(5);
        cell.setCellValue("TOTAL");
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue(totalCobros);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue(totalPayments);
        cell.setCellStyle(style);


        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    private void writeSales(Tx_SalesNumber sales, Row row, CellStyle style) {
        Cell cell = row.createCell(4);
        cell.setCellValue(sales.getTx_Code());
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue(sales.getNumberDocs());
        cell.setCellStyle(style);

    }
    private double writeCobros(Tx_ProductType cobro, Row row, CellStyle style){

        Cell cell = row.createCell(4);
        cell.setCellValue(cobro.getTx_Code());
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue(cobro.getAmount());
        cell.setCellStyle(style);
        double totalCobros = Double.parseDouble(cobro.getAmount());
        return totalCobros;

    }
    private double writePayments(Tx_Payment payment, Row row, CellStyle style){

        Cell cell = row.createCell(4);
        cell.setCellValue(payment.getTx_Code());
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue(payment.getAmount());
        cell.setCellStyle(style);
        double totalPayments = Double.parseDouble(payment.getAmount());
        return  totalPayments;
    }
}
