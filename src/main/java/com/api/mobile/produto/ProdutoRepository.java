package com.api.mobile.produto;

import com.api.mobile.cliente.ClienteView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoView, Long> {

    @Query(value = "SELECT * FROM V_API_PRODUTO ORDER BY descricaoProduto ", nativeQuery = true)
    List<ProdutoView> findAllOrderDescricao();
}
