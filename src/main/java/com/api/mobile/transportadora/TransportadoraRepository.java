package com.api.mobile.transportadora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportadoraRepository extends JpaRepository<TransportadoraView, Long> {
    @Query(value = "SELECT * FROM V_API_TRANSPORTADORA ORDER BY RAZAO ", nativeQuery = true)
    List<TransportadoraView> findAllTransportadora();
}
