package com.example.estoque.controller;

import com.example.estoque.dtos.ProdutoRecordDTO;
import com.example.estoque.produto.Produto;
import com.example.estoque.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/estoque/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> novoProduto(@Valid ProdutoRecordDTO produtoRecordDTO){
        var produto = new Produto();
        BeanUtils.copyProperties(produtoRecordDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> obterProdutoPorId(@PathVariable(value = "id") UUID id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> alterarProduto(@PathVariable(value = "id") UUID id, @Valid ProdutoRecordDTO produtoRecordDTO){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var prod = produto.get();
        BeanUtils.copyProperties(produtoRecordDTO, prod);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(prod));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value = "id") UUID id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        produtoRepository.delete(produto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}
