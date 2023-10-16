package com.example.estoque.produto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Table(name = "produto")
@Entity(name = "produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    private String nome;

    @Min(0)
    private double preco;

    @NotBlank
    private String endereco;

    @NotBlank
    private int quantidade;

}
