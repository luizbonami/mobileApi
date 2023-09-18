package com.api.mobile.municipio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MunicipioViewRepository extends JpaRepository <MunicipioView, Long> {

    @Query(value = "SELECT * FROM V_API_MUNICIPIO WHERE NOME =?1 AND UF =?2 ", nativeQuery = true)
    List<MunicipioView> findByCidadeEstado(String cidade, String uf);
}
