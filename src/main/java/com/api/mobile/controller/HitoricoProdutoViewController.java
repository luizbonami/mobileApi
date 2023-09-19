package com.api.mobile.controller;

import com.api.mobile.historicoproduto.DadosListagemHistorioProdutoView;
import com.api.mobile.historicoproduto.HistoricoProdutoRepository;
import com.api.mobile.movimentacoes.DadosListagemMovimentacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("historico")
public class HitoricoProdutoViewController {

    @Autowired
    HistoricoProdutoRepository historicoProdutoRepository;
    @GetMapping("/{codigoCliente}/{codigoSimilar}")
    public List<DadosListagemHistorioProdutoView> listar(@PathVariable Long codigoCliente, @PathVariable String codigoSimilar){
        return  historicoProdutoRepository.findByCodigoClienteCodigoSimilar(codigoCliente,codigoSimilar).stream().map(DadosListagemHistorioProdutoView::new).toList();
    }

}
