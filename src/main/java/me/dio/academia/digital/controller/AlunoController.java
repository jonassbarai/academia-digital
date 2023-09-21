package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAllAlunos(@RequestParam(value = "dataDeNascimento",required = false) String dataDeNascimento){
        return  service.getAll(dataDeNascimento);
    }
    @PostMapping
    public Aluno createAluno(@Valid @RequestBody AlunoForm form){
        return service.create(form);

    }
    @GetMapping(path = "/{id}/avaliacoes")
    public List<AvaliacaoFisica> getAllAvalicacoes(@PathVariable Long id){
    return service.getAllAvalicaoFisica(id);
    }

}
