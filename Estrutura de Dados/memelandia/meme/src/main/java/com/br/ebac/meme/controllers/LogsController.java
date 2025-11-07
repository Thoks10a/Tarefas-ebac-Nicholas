package com.br.ebac.meme.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.services.ServiceMeme;

@RestController
@RequestMapping("/meme-logs")
public class LogsController {

    private ServiceMeme serviceMeme;

    public LogsController(ServiceMeme serviceMeme) {
        this.serviceMeme = serviceMeme;
    }

    @GetMapping
    public ArrayList<Object> memeLog(Meme meme, String printMemeLogs){
        return serviceMeme.memeLog(meme, printMemeLogs);
    }
}
