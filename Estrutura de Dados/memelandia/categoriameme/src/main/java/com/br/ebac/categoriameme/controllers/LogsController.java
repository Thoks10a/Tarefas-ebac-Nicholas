package com.br.ebac.categoriameme.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.categoriameme.entities.CategoriaMeme;
import com.br.ebac.categoriameme.services.ServiceCategoriaMeme;


@RestController
@RequestMapping("/categoriameme-logs")
public class LogsController {

    private ServiceCategoriaMeme serviceCategoriaMeme;

    public LogsController(ServiceCategoriaMeme serviceCategoriaMeme) {
        this.serviceCategoriaMeme = serviceCategoriaMeme;
    }

    @GetMapping
    public ArrayList<Object> categoriaMemeLog(CategoriaMeme categoriaMeme, String printCategoriaMemeLogs){
        return serviceCategoriaMeme.categoriaMemeLog(categoriaMeme, printCategoriaMemeLogs);
    }
}
