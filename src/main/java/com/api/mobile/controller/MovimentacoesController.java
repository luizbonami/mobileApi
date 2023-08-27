package com.api.mobile.controller;

import com.api.mobile.movimentacoes.DadosCadastroMovimentacoes;
import com.api.mobile.movimentacoes.Movimentacoes;

import com.api.mobile.services.MovimentacoesService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesService movimentacoesService;
    @JsonSerialize
    @PostMapping("/insert")
    public Movimentacoes criarMovimento(@RequestBody DadosCadastroMovimentacoes movimentacoes){
        return movimentacoesService.criarMovimento(movimentacoes);

    }
    /*
    @PostMapping("/insert")
    public Movimentacoes criarMovimentoInsert(@RequestBody Movimentacoes movimentacoes){
        return movimentacoesService.criarMovimento(movimentacoes);

    }
     */

}
