package com.api.mobile.controller;

import com.api.mobile.produto.DadosListagemProdutoDTO;
import com.api.mobile.produto.ProdutoRepository;
import com.api.mobile.representante.DadosListagemRepresentante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutosController {
    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public List<DadosListagemProdutoDTO> listaProdutos(){
        return  repository.findAllOrderDescricao().stream().map(DadosListagemProdutoDTO::new).toList();
    }
}
