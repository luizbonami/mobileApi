package com.api.mobile.tipopagamento;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamentoView, Long> {
    @Query(value = "SELECT * FROM V_API_TIPOPAG ", nativeQuery = true)
    List<TipoPagamentoView> findAllTipoPag();
}
