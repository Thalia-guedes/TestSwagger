package com.example.cadastrar.service;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastro(
        String nome_pessoa,
        String cpf,

        Integer idade,

        String profissao
) {
}
