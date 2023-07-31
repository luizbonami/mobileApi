package com.api.mobile.controller;


import com.api.mobile.representante.DadosCadastroRepresentante;
import com.api.mobile.representante.DadosListagemRepresentante;
import com.api.mobile.representante.Representante;
import com.api.mobile.representante.RepresentanteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("representantes")
public class RepresentantesController {

    @Autowired
    private RepresentanteRepository repository;
    @PostMapping
    public  void cadastrar(@RequestBody DadosCadastroRepresentante dados ){
      repository.save(new Representante(dados));

    }

    @GetMapping
    public Page<DadosListagemRepresentante> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemRepresentante::new);
    }
    @GetMapping("/order")
    public Page<DadosListagemRepresentante> listarordenado(@PageableDefault(sort = {"nome"})  Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemRepresentante::new);
    }

    @GetMapping("/teste")
    public  List<DadosListagemRepresentante> listanova(){
        return  repository.findByTeste().stream().map(DadosListagemRepresentante::new).toList();
    }

    @GetMapping("/teste2")
    public Page<DadosListagemRepresentante> listarTeste(Pageable paginacao){
        return repository.findByTestePage(paginacao).map(DadosListagemRepresentante::new);
    }

}

