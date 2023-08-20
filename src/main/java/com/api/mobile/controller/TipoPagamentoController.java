package com.api.mobile.controller;

import com.api.mobile.condicaopagamento.DadosListagemCondicaoPagamentoDTO;
import com.api.mobile.tipopagamento.DadosListagemTipoPagamentoDTO;
import com.api.mobile.tipopagamento.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tipopagamento")
public class TipoPagamentoController {
    @Autowired
    TipoPagamentoRepository repository;
    @GetMapping
    public List<DadosListagemTipoPagamentoDTO> listaCondicaoPagamento(){
        return  repository.findAllTipoPag().stream().map(DadosListagemTipoPagamentoDTO::new).toList();
    }
}
