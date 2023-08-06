package com.api.mobile.controller;

import com.api.mobile.cliente.ClienteDadosFinanceirosRepository;
import com.api.mobile.cliente.ClienteRepository;
import com.api.mobile.cliente.DadosListagemCliente;

import com.api.mobile.cliente.DadosListagemDadosFinanceirosDTO;
import com.api.mobile.representante.DadosListagemRepresentante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesController {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteDadosFinanceirosRepository repositoryDadosFinanceiros;
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
