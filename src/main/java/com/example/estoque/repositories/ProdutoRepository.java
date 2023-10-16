package com.example.estoque.repositories;

import com.example.estoque.produto.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProdutoRepository extends CrudRepository<Produto, UUID> {

}

