package com.api.mobile.movimentacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentacoesViewRepository extends JpaRepository<MovimentacoesView, Long> {

    @Query(value = "\n" + "SELECT M.* FROM V_API_MOVIMENTACOES M WHERE  M.CODREPRESENTANTE = ?1 " +
                   "ORDER BY M.DATAEMISSAO DESC", nativeQuery = true)
    List<MovimentacoesView> findByCodRepresentante(Long codigoRepresentante);

    @Query(value = "\n" + "SELECT M.* FROM V_API_MOVIMENTACOES M WHERE  M.CODREPRESENTANTE = ?1 AND M.CODFUNCIONARIO1 = ?2 " +
            "ORDER BY M.DATAEMISSAO DESC", nativeQuery = true)
    List<MovimentacoesView> findByCodRepresentanteVendedor(Long codigoRepresentante, Long codigoVendedor);

}
