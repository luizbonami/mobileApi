package com.api.mobile.condicaopagamento;

import com.api.mobile.produto.ProdutoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CondicaoPagamentoRepository extends JpaRepository<CondicaoPagamentoView, Long> {
    @Query(value = "SELECT * FROM V_API_CONDPAG ", nativeQuery = true)
    List<CondicaoPagamentoView> findAllCondPag();
}
