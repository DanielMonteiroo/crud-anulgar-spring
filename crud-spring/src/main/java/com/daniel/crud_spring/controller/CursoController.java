package com.daniel.crud_spring.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}") // Mapeia requisições GET para este método, com um parâmetro de caminho "id"
    public ResponseEntity<Curso> buscaId(@PathVariable Long id) {
        return cursoRepositorio.findById(id)
                .map(busca -> ResponseEntity.ok().body(busca)) //retorna o status 200 e o curso encontrado
                .orElse(ResponseEntity.notFound().build()); //retorna o status 404 caso o curso não seja encontrado
    }

    @PostMapping // Mapeia requisições POST para este método
    public ResponseEntity<Curso> inserir(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoRepositorio.save(curso)); //retorna o status 201 de objeto criado
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso curso){
        return cursoRepositorio.findById(id)
                .map(cursoExistente -> {
                    cursoExistente.setNome(curso.getNome());
                    cursoExistente.setCategoria(curso.getCategoria());
                    Curso cursoAtualizado = cursoRepositorio.save(cursoExistente);
                    return ResponseEntity.ok().body(cursoAtualizado); //retorna o status 200 e o curso atualizado
                })
                .orElse(ResponseEntity.notFound().build());//retorna o status 404 caso o curso não seja encontrado
    }
    
}
