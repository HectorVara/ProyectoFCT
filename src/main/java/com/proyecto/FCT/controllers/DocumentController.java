package com.proyecto.FCT.controllers;
import com.proyecto.FCT.repositories.PaymentRepository;
import com.proyecto.FCT.repositories.LineRepository;
import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.models.queryModels.ICharges;
import com.proyecto.FCT.models.queryModels.IPayments;
import com.proyecto.FCT.models.queryModels.ISales;
import com.proyecto.FCT.repositories.DocumentRepository;
import com.proyecto.FCT.services.ParserXMLService;
import com.proyecto.FCT.services.SaveFolderService;
import com.proyecto.FCT.utils.FileNamesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    private final String path= "C:\\GestorTickets\\XML";
@Autowired
ParserXMLService parserXMLService;
@Autowired
DocumentRepository documentRepository;
@Autowired
SaveFolderService saveFolderService;
@Autowired
LineRepository lineRepository;
@Autowired
PaymentRepository paymentRepository;

    @GetMapping("/xml")
    public Document parseXML(@RequestParam(required = true) String filename){
        return parserXMLService.parseXMLandSave(filename);


    }

    @GetMapping("/savefolder")
    public ResponseEntity<List<String>> getNames() {
        try {
            List<String> fileNames = saveFolderService.saveAllFilesOfFolder();
            return new ResponseEntity<>(fileNames,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sales")
    public ResponseEntity<List<ISales>> getSales(@RequestParam String idStore, @RequestParam String date){
    List<ISales> sales = new ArrayList<>();
    try{
        documentRepository.sales(idStore,date).forEach(sales::add);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
    @GetMapping("allsales")
    public ResponseEntity<List<com.proyecto.FCT.models.persistenceModels.Document>> getAllSales() {
        List<com.proyecto.FCT.models.persistenceModels.Document> documents = new ArrayList<>();
        try {
            documentRepository.findAll().forEach(documents::add);
            return new ResponseEntity<>(documents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAllSales(){
        try{
            lineRepository.deleteAll();
            paymentRepository.deleteAll();
            documentRepository.deleteAll();
            return new ResponseEntity<>("Documentos eliminados con éxito",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Ha habido un error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/payments")
    public ResponseEntity<List<IPayments>> getPayments(@RequestParam String idStore, @RequestParam String date){
    List<IPayments> payments = new ArrayList<>();
    try{
        documentRepository.payments(idStore,date).forEach(payments::add);
        return  new ResponseEntity<>(payments, HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/charges")
    public  ResponseEntity<List<ICharges>> getCharges(@RequestParam String idStore, @RequestParam String date){
    List<ICharges> charges = new ArrayList<>();
    try{
        documentRepository.charges(idStore,date).forEach((charges::add));
        return new ResponseEntity<>(charges,HttpStatus.OK);
    }catch(Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/totalPayments")
    public ResponseEntity<Double> getTotalPayments(@RequestParam String idStore, @RequestParam String date){
    double total=0;
    try{
        total = documentRepository.totalPayments(idStore, date);
        return new ResponseEntity<>(total,HttpStatus.OK);
    }catch(Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/totalCharges")
    public ResponseEntity<Double> getTotalCharges(@RequestParam String idStore, @RequestParam String date){
        double total=0;
        try{
            total = documentRepository.totalCharges(idStore, date);
            return new ResponseEntity<>(total,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
