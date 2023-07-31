package com.api.mobile.representante;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepresentanteRepository  extends JpaRepository<Representante,Long> {

    @Query(value = "SELECT * FROM REPRESENTANTES WHERE NOME LIKE '%CONSTRU%' ", nativeQuery = true)
    List<Representante> findByTeste();

    @Query(value = "SELECT * FROM REPRESENTANTES WHERE NOME LIKE '%CONSTRU%' ", nativeQuery = true)
    Page<Representante> findByTestePage(Pageable pageable);


}
