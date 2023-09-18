package com.api.mobile.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteViewRepository extends JpaRepository<ClienteView,Long> {
/*
    @Query(value = """
            SELECT\s
               C.CODIGO,
               C.RAZAO,
               M.NOME CIDADE,
               UF.IDENTIFICADOR ESTADO,
               C.FONE TELEFONE,
               C.CNPJ,
               C.INSCEST,
               C.FAX CONTATO,
               C.EMAIL,
               C.RUA ENDERECO,
               C.NUMERO,
               C.BAIRRO,
               C.CEP,
               P.NOME PAIS,
               C.OBSERVACOES
            \s
            FROM CLIFORN C
            LEFT JOIN G_MUNICIPIOS M
              ON C.CODIGO_MUNICIPIOS = M.CODIGO
            LEFT JOIN G_UF UF
              ON UF.CODIGO = M.CODIGO_UF
            LEFT JOIN G_PAIS P
              ON P.CODIGO = UF.CODIGO_PAIS
            WHERE C.RAZAO IS NOT NULL
            \tAND C.TIPO LIKE '%CLI%'
            \tAND C.RAZAO NOT LIKE '%(BAIXADA)%'
            \tAND C.RAZAO NOT LIKE '%INATIVO%'
            \tAND C.RAZAO NOT LIKE '%EMCERRADA%'
            \tAND C.CODIGO NOT IN(5454,7128,9006)
            \tAND C.TIPO NOT LIKE '%CONCORRENTE%'
            \tAND C.CODIGO_AREAATUACAO IS NOT NULL
            \tAND C.RAZAO NOT LIKE '%INAPTA%'\s""",
            nativeQuery = true)  */

    @Query(value = "SELECT * FROM V_API_CLIENTE", nativeQuery = true)
    Page<ClienteView> findByClienteView(Pageable pageable);

    @Query(value = "SELECT * FROM V_API_CLIENTE WHERE CODIGO_REPRESENTANTE =?1 ", nativeQuery = true)
    Page<ClienteView> findByCodRepresentante(Long codigoRepresentante, Pageable pageable);

    @Query(value = "SELECT * FROM V_API_CLIENTE ORDER BY razao ", nativeQuery = true)
    List<ClienteView> findAllOrderRazao();


}
