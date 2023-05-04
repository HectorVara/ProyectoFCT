package com.proyecto.FCT.controllers;

import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.models.queryModels.ICharges;
import com.proyecto.FCT.models.queryModels.IPayments;
import com.proyecto.FCT.models.queryModels.ISales;
import com.proyecto.FCT.repositories.DocumentRepository;
import com.proyecto.FCT.services.ParserXMLService;
import com.proyecto.FCT.utils.FileNamesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    private final String path= "C:\\XML";
@Autowired
ParserXMLService parserXMLService;
@Autowired
DocumentRepository documentRepository;

@GetMapping("/xml")
public Document parseXML(@RequestParam(required = true) String filename){
    return parserXMLService.parseXMLandSave(filename);


}
    @GetMapping("/savefolder")
    public ResponseEntity<List<String>> getNames(){
        List<String> fileNames= new ArrayList<>();
        FileNamesParser parser= new FileNamesParser();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        String saveUrl
                = "http://localhost:8080/api/v1/xml?filename=";
        fileNames = parser.getFileNames(path);
        if(fileNames.size() > 0) {

            for (int i = 0; i < fileNames.size(); i++) {

                Document d = restTemplate.getForObject(saveUrl + fileNames.get(i), Document.class);
            }
        }else{
            fileNames.add("No hay archivos en la carpeta o la ruta es erronea");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(fileNames, headers, HttpStatus.CREATED);
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
