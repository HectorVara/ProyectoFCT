package com.proyecto.FCT.controllers;

import com.proyecto.FCT.services.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jasper")
public class JasperController {
    @Autowired
    JasperService jasperService;


    @GetMapping("/pdf/{id}")
    public ResponseEntity<byte[]> generatePdf(@PathVariable String id){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        try{
            return new ResponseEntity<>(jasperService.createJasperReport(Long.parseLong(id)),headers, HttpStatus.OK);
        }catch(Exception e){
            return null;
        }

    }

    @GetMapping("/pdfinbytes")
    public byte[] showPdf(){

        return jasperService.getPdfToBytes();
    }


}
