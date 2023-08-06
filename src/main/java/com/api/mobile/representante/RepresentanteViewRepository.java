package com.api.mobile.representante;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepresentanteViewRepository extends JpaRepository<RepresentanteView,Long> {

    @Query(value = "SELECT * FROM V_API_REPRESENTANTE", nativeQuery = true)
    Page<RepresentanteView> findByRepresentanteView(Pageable pageable);

    @Query(value = "SELECT * FROM V_API_REPRESENTANTE WHERE CODIGO  =?1 ", nativeQuery = true)
    Page<RepresentanteView> findByCodigo(Long codigo, Pageable pageable);

}
