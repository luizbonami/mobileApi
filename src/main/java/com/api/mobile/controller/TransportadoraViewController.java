package com.api.mobile.controller;

import com.api.mobile.transportadora.DadosListagemTransportadoraDTO;
import com.api.mobile.transportadora.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("transportadora")
public class TransportadoraViewController {

    @Autowired
    TransportadoraRepository transportadoraRepository;

    @GetMapping
    public List<DadosListagemTransportadoraDTO> listaTransportadora(){
        return transportadoraRepository.findAllTransportadora().stream().map(DadosListagemTransportadoraDTO::new).toList();
    }


}
