package com.api.mobile.usuario;

import com.api.mobile.cliente.ClienteView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioViewRepository extends JpaRepository<UsuarioView, Long> {
    @Query(value = "SELECT * FROM V_API_USUARIO ORDER  BY NOME", nativeQuery = true)
    List<UsuarioView> findAllUsuario();

    @Query(value = "SELECT * FROM V_API_USUARIO WHERE CODIGO_REPRESENTANTE =?1 ORDER  BY NOME", nativeQuery = true)
    List<UsuarioView> findByCodRepresentante(Long codigoRepresentante);

}
