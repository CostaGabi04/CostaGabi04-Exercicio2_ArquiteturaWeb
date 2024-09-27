package com.example.exercicio2.repository;

import com.example.exercicio2.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByPrecoGreaterThan(Double valor);
    List<Produto> findByPrecoLessThanEqual(Double valor);
    List<Produto> findByNomeStartingWith(String nome);
}