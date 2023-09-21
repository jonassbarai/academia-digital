package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {
    @Autowired
    private AlunoRepository repository;
    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = form.toEntity();
        return repository.save(aluno);
    }

    @Override
    public Optional<Aluno> get(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id)));

    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null)
            return repository.findAll();
        else{
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findBydataDeNascimento(localDate);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public List<AvaliacaoFisica> getAllAvalicaoFisica(Long id){

        Aluno aluno = repository.findById(id).get();

        return aluno.getAvaliacoes();
    }


}
