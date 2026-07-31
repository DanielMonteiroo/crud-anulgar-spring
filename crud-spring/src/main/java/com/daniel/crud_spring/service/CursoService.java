package com.daniel.crud_spring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.daniel.crud_spring.model.Curso;
import com.daniel.crud_spring.repository.CursoRepositorio;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CursoService {
   
    private final CursoRepositorio cursoRepositorio; // Injeção de dependência do repositório
    
    // Construtor para injeção de dependência do repositório
    public CursoService(CursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    // Método para listar todos os cursos
     public List<Curso> lista() {
        return cursoRepositorio.findAll(); // Retorna uma lista contendo o curso criado
    }

    // Método para buscar um curso pelo ID
      public Optional<Curso> buscaId(@PathVariable @NotNull @Positive Long id) {
        return cursoRepositorio.findById(id);
    }

    // Método para criar um novo curso
     public Curso inserir(@RequestBody @Valid Curso curso){
        return cursoRepositorio.save(curso); //retorna o status 201 de objeto criado
    }

    // Método para atualizar um curso existente
    public Optional<Curso> atualizar(@NotNull @Positive Long id, @Valid Curso curso){
        return cursoRepositorio.findById(id)
                .map(cursoExistente -> {
                    cursoExistente.setNome(curso.getNome());
                    cursoExistente.setCategoria(curso.getCategoria());
                 return cursoRepositorio.save(cursoExistente);
                    
                });
    }

    // Método para deletar um curso existente
    public boolean deletar(@PathVariable @NotNull @Positive Long id) {
        return cursoRepositorio.findById(id)
                .map(curso -> {
                    cursoRepositorio.deleteById(id);
                    return true;
                })
                .orElse(false);
            }   


}//chave que fecha a classe CursoService
