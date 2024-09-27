package com.example.exercicio2;

import com.example.exercicio2.models.Categoria;
import com.example.exercicio2.models.Produto;
import com.example.exercicio2.repository.CategoriaRepository;
import com.example.exercicio2.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Startup implements CommandLineRunner {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public Startup(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        // Adicionando categorias
        Categoria c1 = new Categoria(null, "Eletrônicos");
        Categoria c2 = new Categoria(null, "Móveis");
        Categoria c3 = new Categoria(null, "Comida");
        Categoria c4 = new Categoria(null, "Bebida");
        categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        // Adicionando produtos
        Produto p1 = new Produto(null, "Smartphone", 2900.90);
        p1.setCategoria(c1);
        Produto p2 = new Produto(null, "Fone de Ouvido", 299.00);
        p2.setCategoria(c1);
        Produto p3 = new Produto(null, "Mesa", 259.90);
        p3.setCategoria(c2);
        Produto p4 = new Produto(null, "Cadeira Gamer", 900.00);
        p4.setCategoria(c2);
        Produto p5 = new Produto(null, "Barra de chocolate ao leite", 9.90);
        p5.setCategoria(c3);
        Produto p6 = new Produto(null, "Batata Lays", 5.90);
        p6.setCategoria(c3);
        Produto p7 = new Produto(null, "Água com Gás", 2.49);
        p7.setCategoria(c4);
        Produto p8 = new Produto(null, "Chá Mate Pessego", 3.90);
        p8.setCategoria(c4);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

        // Testando o método findByNomeStartingWith
        System.out.println("Categorias que começam com 'E':");
        categoriaRepository.findByNomeStartingWith("E")
                .forEach(categoria -> System.out.println(categoria.getNome()));

        // Testando o método findByIdWithProdutos
        System.out.println("Produtos da categoria com ID 1:");
        Categoria categoria = categoriaRepository.findByIdWithProdutos(1L);
        if (categoria != null) {
            categoria.getProdutos().forEach(produto -> System.out.println(produto.getNome()));
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }
}