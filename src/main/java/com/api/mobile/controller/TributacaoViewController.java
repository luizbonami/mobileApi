package com.api.mobile.controller;


import com.api.mobile.tributacao.DadosListagemTributacaoViewDTO;
import com.api.mobile.tributacao.TributacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("tributacao")
public class TributacaoViewController {
    @Autowired
    TributacaoRepository tributacaoRepository;

    @GetMapping
    public List<DadosListagemTributacaoViewDTO> listaTributacao(){
        return tributacaoRepository.findAllTributacao().stream().map(DadosListagemTributacaoViewDTO::new).toList();
    }



}
