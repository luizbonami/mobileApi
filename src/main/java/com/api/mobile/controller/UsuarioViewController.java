package com.api.mobile.controller;

import com.api.mobile.cliente.DadosListagemCliente;
import com.api.mobile.usuario.DadosListagemUsuarioViewDTO;
import com.api.mobile.usuario.UsuarioViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioViewController {

    @Autowired
    UsuarioViewRepository usuarioViewRepository;

    @GetMapping
    public List<DadosListagemUsuarioViewDTO> listar(){
        return usuarioViewRepository.findAllUsuario().stream().map(DadosListagemUsuarioViewDTO::new).toList();
    }

    @GetMapping("/{codigoRepresentante}")
    public List<DadosListagemUsuarioViewDTO> listarPorCodigoRepresentante(@PathVariable Long codigoRepresentante) {
        return usuarioViewRepository.findByCodRepresentante(codigoRepresentante).stream().map(DadosListagemUsuarioViewDTO::new).toList();
    }


}
