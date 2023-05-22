package com.proyecto.FCT.controllers;

import com.proyecto.FCT.models.persistenceModels.Document;
import com.proyecto.FCT.repositories.DocumentRepository;
import com.proyecto.FCT.repositories.LineRepository;
import com.proyecto.FCT.services.DocumentPage;
import com.proyecto.FCT.services.SerializeXML;
import com.proyecto.FCT.utils.TransactionsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ViewController {

    private String storeParameter;
    private String dateParameter;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    DocumentPage documentPage;
    @Autowired
    LineRepository lineRepository;
    @Autowired
    SerializeXML serializeXML;
    @Autowired
    TransactionsAdapter adapter;

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/documents")
    public String getAllPages(@RequestParam(required = false)String idStore,
                              @RequestParam(required = false) String date,
                              Model model){
    //Para que la primera vez que se abra /documents, no salgan las tablas vacías, se le dan unos valores por defecto
        if(idStore==null || date==null)
            return getOnePageSalesByStoreAndDate(model,"694", "2023-04-10",1);
        else
            //return getOnePage(model, 1);
            return getOnePageSalesByStoreAndDate(model,idStore, date,1);
    }

    @GetMapping("/documents/page/{pageNumber}")
    public String getOnePageSalesByStoreAndDate(Model model,
                                                String idStore,
                                                String date, @PathVariable("pageNumber") int currentPage){

        if(idStore!=null)
            storeParameter = idStore;
        if(date!=null)
            dateParameter = date;
        Page<Document> page = documentPage.findPageByStoreAndDate(PageRequest.of(currentPage - 1, 20),storeParameter,dateParameter);

        int totalPages = page.getTotalPages();

        long totalItems = page.getTotalElements();
        List<Document> documents = page.getContent();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("page",page);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("documents", documents);
        model.addAttribute("sales",documentRepository.sales(idStore,date));
        model.addAttribute("payments",documentRepository.payments(idStore,date));
        model.addAttribute("lines",lineRepository.findAll());
        model.addAttribute("cobros",documentRepository.cobros(idStore,date));
        model.addAttribute("idStore",idStore);
        model.addAttribute("date",date);
        return "documents";
    }
    @GetMapping("/resumen")
    public String resumen(Model model, @RequestParam(required = true) String idStore,@RequestParam(required = true) String date){
        List<String> tiendaYFecha = new ArrayList<>();
        tiendaYFecha.add(idStore);
        tiendaYFecha.add(date);
        model.addAttribute("sales",documentRepository.sales(idStore, date));
        model.addAttribute("cobros",documentRepository.cobros(idStore, date));
        model.addAttribute("payments",documentRepository.payments(idStore,date));
        model.addAttribute("totalCobro", documentRepository.totalCobros(idStore,date));
        model.addAttribute("totalPayment",documentRepository.totalPayments(idStore,date));
        model.addAttribute("tiendaFecha",tiendaYFecha);
        return "resumen";
    }
    @GetMapping("/generateDocuments")
    public String serialize(@RequestParam(required = true) String idStore, @RequestParam(required = true) String date){

        try {
            serializeXML.serialize(idStore, date);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return "index";
    }
}


