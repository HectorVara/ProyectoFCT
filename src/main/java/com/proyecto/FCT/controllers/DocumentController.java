package com.proyecto.FCT.controllers;

import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.models.parseModels.Transaction;
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
}
