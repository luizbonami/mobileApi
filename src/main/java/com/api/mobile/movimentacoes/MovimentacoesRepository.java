package com.api.mobile.movimentacoes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {
    Page<Movimentacoes> findAll(Pageable pageable);

    @Query(value = "\n" + "SELECT * FROM MOVIMENTACOES WHERE IDMOV <> '' AND DATEPART(YEAR,DATAEMISSAO) >2022 AND STATUS NOT IN(6) AND CODTIPOMOV IN('2.1.01') AND CODREPRESENTANTE = ?1 ORDER BY DATAEMISSAO DESC", nativeQuery = true)
    List<Movimentacoes> findByCodRepresentante(Long codigoRepresentante);

    @Query(value = "\n" + "SELECT * FROM MOVIMENTACOES WHERE IDMOV <> '' AND DATEPART(YEAR,DATAEMISSAO) >2022 AND STATUS NOT IN(6) AND CODTIPOMOV IN('2.1.01') AND CODREPRESENTANTE = ?1 AND CODCLIFORN = ?2 ORDER BY DATAEMISSAO DESC", nativeQuery = true)
    List<Movimentacoes> findByCodRepCodCliente(Long codigoRepresentante,Long codigoCliente);



}
