package com.example.cadastrar.controller;

import com.example.cadastrar.service.DadosCadastro;
import com.example.cadastrar.service.PessoaRepository;
import com.example.cadastrar.model.PessoaModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastro dados){
        var pessoa = new PessoaModel(dados);
        repository.save(pessoa);
        return ResponseEntity.ok(pessoa);
    }
    @GetMapping
    public List<PessoaModel> listar() {
        return repository.findAll();
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizarPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarProfissao(dados);
        return ResponseEntity.ok(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
