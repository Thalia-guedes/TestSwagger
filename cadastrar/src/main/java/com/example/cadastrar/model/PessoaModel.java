package com.example.cadastrar.model;

import com.example.cadastrar.controller.DadosAtualizarPessoa;
import com.example.cadastrar.service.DadosCadastro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name = "pessoa")
@Entity(name = "Pessoa")
@NoArgsConstructor
@Getter
@Setter
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_pessoa")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "idade")
    private int idade;
    @Column(name = "profissao")
    private String profissao;

    public PessoaModel(DadosCadastro dados) {
        this.nome = dados.nome_pessoa();
        this.cpf = dados.cpf();
        this.idade = dados.idade();
        this.profissao = dados.profissao();
    }
    public void atualizarProfissao(DadosAtualizarPessoa dados){
        if (dados.profissao() != null){
            this.profissao = dados.profissao();
        }
    }
}
