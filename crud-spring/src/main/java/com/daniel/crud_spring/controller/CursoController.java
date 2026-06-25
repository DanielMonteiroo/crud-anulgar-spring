package com.daniel.crud_spring.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.daniel.crud_spring.model.Curso;
import com.daniel.crud_spring.repository.CursoRepositorio;

import lombok.AllArgsConstructor;

@RestController // Indica que esta classe é um controlador REST e os métodos retornarão dados JSON
@RequestMapping("/api/cursos")// Define a rota base para este controlador
@AllArgsConstructor // Gera um construtor com um parâmetro para cada campo da classe, facilitando a injeção de dependências
public class CursoController {

    private final CursoRepositorio cursoRepositorio; // Injeção de dependência do repositório

    @GetMapping // Mapeia requisições GET para este método
    public List<Curso> lista() {
        return cursoRepositorio.findAll(); // Retorna uma lista contendo o curso criado
    }

    @PostMapping // Mapeia requisições POST para este método
    public ResponseEntity<Curso> inserir(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoRepositorio.save(curso)); //retorna o status 201 de objeto criado
    }
    
}
