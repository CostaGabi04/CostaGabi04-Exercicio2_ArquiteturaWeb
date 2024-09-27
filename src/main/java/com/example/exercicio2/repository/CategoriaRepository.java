package com.example.exercicio2.repository;

import com.example.exercicio2.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // Método que retorna todas as categorias que começam com um determinado nome
    List<Categoria> findByNomeStartingWith(String nome);

    // Método que retorna uma determinada categoria pelo ID e seus produtos
    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.id = :id")
    Categoria findByIdWithProdutos(@Param("id") Long id);
}
