package com.api.mobile.movimentacoes;

import com.api.mobile.representante.Representante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {
    Page<Movimentacoes> findAll(Pageable pageable);
}
