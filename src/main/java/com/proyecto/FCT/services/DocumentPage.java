package com.proyecto.FCT.services;

import com.proyecto.FCT.models.persistenceModels.Document;
import com.proyecto.FCT.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DocumentPage {

    @Autowired
    DocumentRepository documentRepository;


    public Page<Document> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1,10);
        return documentRepository.findAll(pageable);
    }

  /*   public Page<Document> findPageByStoreAndDate(int pageNumber, String idStore, String date){
        Pageable pageable = PageRequest.of(pageNumber - 1,10);
        return documentRepository.findByIdStoreAndSessionDate(pageable, idStore, date);
    }*/

    public Page<Document> findPageByStoreAndDate(Pageable pageable, String idStore, String date){


        List<Document> documents= documentRepository.getIdStoreAndDate(idStore,date);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Document> list;

        if (documents.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, documents.size());
            list = documents.subList(startItem, toIndex);
        }

        Page<Document> page
                = new PageImpl<Document>(list, PageRequest.of(currentPage, pageSize), documents.size());

        return page;
    }

}
