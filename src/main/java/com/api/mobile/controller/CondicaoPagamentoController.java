package com.api.mobile.controller;

import com.api.mobile.condicaopagamento.CondicaoPagamentoRepository;
import com.api.mobile.condicaopagamento.DadosListagemCondicaoPagamentoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("condicaopagamento")
public class CondicaoPagamentoController {
    @Autowired
    CondicaoPagamentoRepository repository;
    @GetMapping
    public List<DadosListagemCondicaoPagamentoDTO> listaCondicaoPagamento(){
        return  repository.findAllCondPag().stream().map(DadosListagemCondicaoPagamentoDTO::new).toList();
    }
}
