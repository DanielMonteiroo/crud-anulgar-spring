package com.daniel.crud_spring.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.daniel.crud_spring.dto.CursoDTO;
import com.daniel.crud_spring.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated // Habilita a validação de parâmetros de método, como @NotNull e @Positive
@RestController // Indica que esta classe é um controlador REST e os métodos retornarão dados JSON
@RequestMapping("/api/cursos")// Define a rota base para este controlador
public class CursoController {

    private final CursoService cursoService; // Injeção de dependência do serviço
    
    // Construtor para injetar o serviço de curso
    public CursoController(CursoService cursoService) {
    this.cursoService = cursoService;
}

    @GetMapping // Metodo para listar todos os cursos, mapeado para requisições GET
    public List<CursoDTO> lista() {
        return cursoService.lista(); // Retorna uma lista contendo o curso criado
    }

    @GetMapping("/{id}") // Metodo para buscar um curso pelo ID, mapeado para requisições GET com um parâmetro de caminho
    public CursoDTO buscaId(@PathVariable @NotNull @Positive Long id) {
        return cursoService.buscaId(id);
 
    }

    @PostMapping // Metodo para criar um novo curso, mapeado para requisições POST
    public CursoDTO inserir(@RequestBody @Valid CursoDTO curso){
        return cursoService.inserir(curso); //retorna o status 201 de objeto criado
    }

    // Metodo para atualizar um curso existente, mapeado para requisições PUT com um parâmetro de caminho
    @PutMapping("/{id}")
    public CursoDTO atualizar(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid CursoDTO curso){
        return cursoService.atualizar(id, curso); // Retorna o curso atualizado ou lança uma exceção se não encontrado
    }

    // Metodo para deletar um curso existente, mapeado para requisições DELETE com um parâmetro de caminho
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Define o status HTTP como 204 No Content
        public void deletar(@PathVariable @NotNull @Positive Long id) {
        cursoService.deletar(id); // Deleta o curso encontrado ou lança uma exceção se não encontrado
    }
    
}
