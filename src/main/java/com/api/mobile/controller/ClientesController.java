package com.api.mobile.controller;

import com.api.mobile.cliente.ClienteRepository;
import com.api.mobile.cliente.DadosListagemCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("clientes")
public class ClientesController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public Page<DadosListagemCliente> listar(Pageable paginacao){
        return repository.findByClienteView(paginacao).map(DadosListagemCliente::new);
    }

    @GetMapping("/{codigoRepresentante}")
    public Page<DadosListagemCliente> listarPorCodigoRepresentante(@PathVariable Long codigoRepresentante, Pageable paginacao) {
        return repository.findByCodRepresentante(codigoRepresentante, paginacao).map(DadosListagemCliente::new);
    }

}
