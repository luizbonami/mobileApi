package com.api.mobile.tributacao;

import com.api.mobile.tipopagamento.TipoPagamentoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TributacaoRepository extends JpaRepository<TributacaoView, Long> {
    @Query(value = "SELECT * FROM V_API_TRIBUTACAO ", nativeQuery = true)
    List<TributacaoView> findAllTributacao();
}
