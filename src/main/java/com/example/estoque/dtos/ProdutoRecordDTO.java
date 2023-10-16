package com.example.estoque.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public record ProdutoRecordDTO(@NotBlank String nome, @NotNull Double preco, @NotBlank String endereco, @NotNull Integer quantidade) {
}
