package com.proyecto.FCT.services;

import com.proyecto.FCT.models.parseModels.Document;
import com.proyecto.FCT.utils.FileNamesParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class SaveFolderService {
    private final String path= "C:\\XML";
    public List<String> saveAllFilesOfFolder(){
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
        }
        return fileNames;

    }
}
