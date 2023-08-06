package com.api.mobile.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteDadosFinanceirosRepository extends JpaRepository<ClienteDadosFinanceiros,Long> {

    @Query(value = "SELECT * FROM V_API_CLIENTE_DADOS_FINANCEIROS WHERE codigorepresentante =?1 and codigocliente =?2 ", nativeQuery = true)
    Page<ClienteDadosFinanceiros> findDadosFinanceirosByCodRepCodCliente(Long codigoRepresentante, Long codigoCliente, Pageable pageable);
}
