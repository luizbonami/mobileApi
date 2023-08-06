package com.api.mobile.controller;


import com.api.mobile.representante.DadosListatemRepresentanteViewDTO;
import com.api.mobile.representante.RepresentanteViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("representantes")
public class RepresentanteViewController {

    @Autowired
    private RepresentanteViewRepository repository;

    @GetMapping
    public Page<DadosListatemRepresentanteViewDTO> listar(Pageable paginacao){
        return repository.findByRepresentanteView(paginacao).map(DadosListatemRepresentanteViewDTO::new);
    }

    @GetMapping("/{codigo}")
    public Page<DadosListatemRepresentanteViewDTO> listarPorCodigo(@PathVariable Long codigo, Pageable paginacao) {
        return repository.findByCodigo(codigo, paginacao).map(DadosListatemRepresentanteViewDTO::new);
    }


}
