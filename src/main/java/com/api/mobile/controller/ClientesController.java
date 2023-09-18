package com.api.mobile.controller;

import com.api.mobile.cliente.*;


import com.api.mobile.services.ClienteService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesController {
    @Autowired
    private ClienteViewRepository repository;

    @Autowired
    private ClienteDadosFinanceirosRepository repositoryDadosFinanceiros;

    @Autowired
    private ClienteService clienteService;
    @JsonSerialize
    @PostMapping("/insert")
    public ResponseEntity<String> criarCliente(@RequestBody @Valid DadosCadastroCliente cliente){
        if(clienteService.cnpjJaExiste(cliente.cnpj())){
            return ResponseEntity.badRequest().body("CNPJ já cadastrado");
        }
        clienteService.CadastrarCliente(cliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso!");
    }


    @GetMapping
    public Page<DadosListagemCliente> listar(Pageable paginacao){
        return repository.findByClienteView(paginacao).map(DadosListagemCliente::new);
    }

    @GetMapping("/{codigoRepresentante}")
    public Page<DadosListagemCliente> listarPorCodigoRepresentante(@PathVariable Long codigoRepresentante, @PageableDefault(sort = {"razao"},size = 1500)  Pageable paginacao) {
        return repository.findByCodRepresentante(codigoRepresentante, paginacao).map(DadosListagemCliente::new);
    }


    @GetMapping("financeiro/{codigoRepresentante}/{codigoCliente}")
    public Page<DadosListagemDadosFinanceirosDTO> listarDadosFinanceirosCl(@PathVariable Long codigoRepresentante,@PathVariable Long codigoCliente,  Pageable paginacao) {
        return repositoryDadosFinanceiros.findDadosFinanceirosByCodRepCodCliente(codigoRepresentante,codigoCliente, paginacao).map(DadosListagemDadosFinanceirosDTO::new);
    }

    @GetMapping("/teste")
    public List<DadosListagemCliente> listanova(){
        return  repository.findAllOrderRazao().stream().map(DadosListagemCliente::new).toList();
        //Sort.by(Sort.Direction.ASC, "razao"
    }
}
