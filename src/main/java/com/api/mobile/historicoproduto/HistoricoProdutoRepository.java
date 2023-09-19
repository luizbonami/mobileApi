package com.api.mobile.historicoproduto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoricoProdutoRepository extends JpaRepository<HistoricoProdutoView, Long> {
    @Query(value = "\n" + "SELECT TOP 10 * FROM V_API_HISTORICO_PRODUTO WHERE  codigoCliente = ?1  AND codigoSimilar = ?2  ORDER BY dataEmissao DESC", nativeQuery = true)
    List<HistoricoProdutoView> findByCodigoClienteCodigoSimilar(Long codigoCliente, String codigoSimilar);
}
