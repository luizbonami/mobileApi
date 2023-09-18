package com.api.mobile.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT TOP 1 * FROM CLIFORN WHERE CNPJ =?1 ", nativeQuery = true)
    Cliente findByCnpj(String cnpj);
}
