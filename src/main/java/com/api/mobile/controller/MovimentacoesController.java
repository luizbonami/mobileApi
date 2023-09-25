package com.api.mobile.controller;


import com.api.mobile.movimentacoes.*;

import com.api.mobile.services.MovimentacoesService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesService movimentacoesService;

    @Autowired
    MovimentacoesRepository movimentacoesRepository;

    @Autowired
    MovimentacoesViewRepository movimentacoesViewRepository;
    @JsonSerialize
    @PostMapping("/insert")
    public Movimentacoes criarMovimento(@RequestBody DadosCadastroMovimentacoes movimentacoes){
        return movimentacoesService.criarMovimento(movimentacoes);

    }

    @PutMapping("/edit/{codigo}")
    @Transactional
    public ResponseEntity<?> atualizarMovimentacoes(@PathVariable Long codigo, @RequestBody DadosAtualizacaoMovimentacoes dados){

        var movimentacao  = movimentacoesRepository.getReferenceById(codigo);

        if (movimentacao == null){
            return ResponseEntity.notFound().build();
        }
        movimentacao.atualizarDadosMovimento(dados);

        return ResponseEntity.ok().body("movimentacaoAtualizada");
    }

    @GetMapping("/list/{codigoRepresentante}")
    public List<DadosListagemMovimentacoes> listarPorRepresentante(@PathVariable Long codigoRepresentante ){
        return  movimentacoesViewRepository.findByCodRepresentante(codigoRepresentante).stream().map(DadosListagemMovimentacoes::new).toList();
    }

   @GetMapping("/list/{codigoRepresentante}/{codigoVendedor}")
    public List<DadosListagemMovimentacoes> listarPorRepresentanteCliente(@PathVariable Long codigoRepresentante, @PathVariable Long codigoVendedor){
        return  movimentacoesViewRepository.findByCodRepresentanteVendedor(codigoRepresentante,codigoVendedor).stream().map(DadosListagemMovimentacoes::new).toList();
    }
/*
    @GetMapping("/{codigo}")
    public List<DadosListagemMovimentacoes> listarPorCodigo(@PathVariable Long codigo){
        return  movimentacoesRepository.findById(codigo).stream().map(DadosListagemMovimentacoes::new).toList();
    }
*/
}
