package com.proyecto.FCT.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//Ésta clase obtiene una lista con todos los nombres de archivo que hay en un directorio pasado por parámetro
public class FileNamesParser {
    public List<String> getFileNames(String path){
        List<String> fileNames= new ArrayList<>();
        File folder = new File(path);
        if(folder.exists()) {
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile())//Si es un directorio lo ignoramos
                    fileNames.add(listOfFiles[i].getName());
            }
        }

        return fileNames;
    }
}
