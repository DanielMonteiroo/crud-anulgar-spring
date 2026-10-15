package com.daniel.crud_spring.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.daniel.crud_spring.exception.RecordNotfoundException;
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
      public Curso buscaId(@PathVariable @NotNull @Positive Long id) {
        return cursoRepositorio.findById(id).orElseThrow(() -> new RecordNotfoundException(id)); 
        // Retorna o curso encontrado ou lança uma exceção se não encontrado
    }

    // Método para criar um novo curso
     public Curso inserir(@RequestBody @Valid Curso curso){
        return cursoRepositorio.save(curso); //retorna o status 201 de objeto criado
    }

    // Método para atualizar um curso existente
    public Curso atualizar(@NotNull @Positive Long id, @Valid Curso curso){
        return cursoRepositorio.findById(id)
                .map(cursoExistente -> {
                    cursoExistente.setNome(curso.getNome());
                    cursoExistente.setCategoria(curso.getCategoria());
                 return cursoRepositorio.save(cursoExistente);
                    
                }).orElseThrow(() -> new RecordNotfoundException(id)); // Retorna o curso atualizado ou lança uma exceção se não encontrado
    }

    // Método para deletar um curso existente
    public void deletar(@PathVariable @NotNull @Positive Long id) {
         cursoRepositorio.delete(cursoRepositorio.findById(id).orElseThrow(() -> new RecordNotfoundException(id)));
         // Deleta o curso encontrado ou lança uma exceção se não encontrado
    }


}//chave que fecha a classe CursoService
