package com.proyecto.FCT.controllers;

import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.models.parseModels.Transaction;
import com.proyecto.FCT.services.ParserXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
@Autowired
ParserXMLService parserXMLService;

@GetMapping("/xml")
public Document parseXML(@RequestParam(required = true) String filename){
    return parserXMLService.parseXML(filename);


}
}
