package com.api.mobile.services;

import com.api.mobile.cliente.Cliente;
import com.api.mobile.cliente.ClienteRepository;
import com.api.mobile.cliente.DadosCadastroCliente;
import com.api.mobile.contato.Contato;
import com.api.mobile.contato.DadosCadastroContato;

import com.api.mobile.municipio.MunicipioView;
import com.api.mobile.municipio.MunicipioViewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    MunicipioViewRepository municipioViewRepository;

    public Cliente CadastrarCliente(DadosCadastroCliente dados){
        Cliente cliente = new Cliente();
        cliente.setCodigoFilial(dados.codigoFilial());
        cliente.setRazao(dados.razao());
        cliente.setNomefantasia(dados.nomefantasia());
        cliente.setTipo("ANÁLISE FINANCEIRA");
        cliente.setPesfisoujur("JURÍDICA");
        cliente.setCnpj(dados.cnpj());
        cliente.setInscest(dados.inscricaoEstadual());
        cliente.setCodigoAreaatuacao(dados.codigoAreaatuacao());
        cliente.setRua(dados.rua());
        cliente.setNumero(dados.numero());
        cliente.setComplemento(dados.complemento());
        cliente.setBairro(dados.bairro());
        cliente.setCodigoPais(1L);
        cliente.setCodigoMunicipios(RetornaCodigoMunicipio(dados.cidade(), dados.estado()));
        cliente.setCep(dados.cep());
        cliente.setFone(dados.fone());
        cliente.setEmail(dados.email());
        cliente.setAtivo("SIM");
        cliente.setDataCadastro(LocalDate.now());
        cliente.setObservacoes(dados.observacoes());

        for (DadosCadastroContato contatoDTO : dados.contato()) {
           Contato contato = new Contato();
           contato.setCliente(cliente);
           contato.setNomecontato(contatoDTO.nomeContato());
           contato.setCargocontato(contatoDTO.cargoContato());
           contato.setDataaniversariocontato(contatoDTO.dataAniversarioContato());
           contato.setFaxcontato(contatoDTO.whatsApp());
           contato.setEmailcontato(contatoDTO.emailContato());
           contato.setDataLivre1(LocalDate.now());
           cliente.getContato().add(contato);
        }
        return clienteRepository.save(cliente);
    }

    public boolean cnpjJaExiste(String cnpj) {
        Cliente cliente = clienteRepository.findByCnpj(cnpj);
        return cliente != null;
    }

    private Long RetornaCodigoMunicipio(String cidade, String estado) {
        List<MunicipioView> municipios = municipioViewRepository.findByCidadeEstado(cidade, estado);
        if (! municipios.isEmpty()) {
            MunicipioView municipio = municipios.get(0);
            return municipio.getCodigo();
        } else {
            return null;
        }
    }

}
