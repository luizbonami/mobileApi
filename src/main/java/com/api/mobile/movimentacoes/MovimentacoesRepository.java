package com.api.mobile.movimentacoes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {
    Page<Movimentacoes> findAll(Pageable pageable);

    @Query(value = "\n" + "SELECT M.*, " +
                          "CP.DESCRICAO descCondpagamento " +
                          "FROM " +
                          "MOVIMENTACOES M " +
                          "LEFT JOIN CONDICOESPAGAMENTO CP\n" +
                          "  ON CP.CODIGO = M.CODCONDICOESPAGAMENTO  " +
                          "WHERE M.IDMOV <> '' " +
                          "AND DATEPART(YEAR,M.DATAEMISSAO) >2022 " +
                          "AND M.STATUS NOT IN(0,4,5) " +
                          "AND M.CODTIPOMOV IN('2.1.01') " +
                          "AND M.CODREPRESENTANTE = ?1 " +
                          "ORDER BY M.DATAEMISSAO DESC", nativeQuery = true)
    List<Movimentacoes> findByCodRepresentante(Long codigoRepresentante);

    @Query(value = "\n" + "SELECT * FROM MOVIMENTACOES WHERE IDMOV <> '' AND DATEPART(YEAR,DATAEMISSAO) >2022 AND STATUS NOT IN(6) AND CODTIPOMOV IN('2.1.01') AND CODREPRESENTANTE = ?1 AND CODCLIFORN = ?2 ORDER BY DATAEMISSAO DESC", nativeQuery = true)
    List<Movimentacoes> findByCodRepCodCliente(Long codigoRepresentante,Long codigoCliente);


    @Modifying
    @Query(value =  "DELETE FROM ITENSMOVIMENTACOES_CALCULOS_TRIBUTO\n" +
            "WHERE CODIGO_ITENSMOVIMENTACOESTRIBUTO IN(SELECT CODIGO FROM  ITENSMOVIMENTACOES_TRIBUTO\n" +
            "WHERE CODIGO_ITENSMOVIMENTACOES IN (\n" +
            "                                      SELECT CODIGO FROM ITENSMOVIMENTACOES\n" +
            "                                      WHERE CODMOV = ?1 ))\n" +
            "                                      \n" +
            "                                      \n" +
            "DELETE FROM  ITENSMOVIMENTACOES_TRIBUTO\n" +
            "WHERE CODIGO_ITENSMOVIMENTACOES IN (\n" +
            "                                      SELECT CODIGO FROM ITENSMOVIMENTACOES\n" +
            "                                      WHERE CODMOV = ?1 )     \n" +
            "DELETE FROM ITENSMOVIMENTACOES\n" +
            "WHERE CODMOV = ?1", nativeQuery = true)
    void deletarItensMovimentacoesPorId(Long codigo);


}
