package com.daniel.crud_spring.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.daniel.crud_spring.dto.CursoDTO;
import com.daniel.crud_spring.dto.mapper.CursoMapper;
import com.daniel.crud_spring.exception.RecordNotfoundException;
import com.daniel.crud_spring.repository.CursoRepositorio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CursoService {
   
    private final CursoRepositorio cursoRepositorio; // Injeção de dependência do repositório
    private final CursoMapper cursoMapper; // Injeção de dependência do mapper
    
    // Construtor para injeção de dependência do repositório
    public CursoService(CursoRepositorio cursoRepositorio, CursoMapper cursoMapper) {
        this.cursoRepositorio = cursoRepositorio;
        this.cursoMapper = cursoMapper;
    }

    // Método para listar todos os cursos
     public List<CursoDTO> lista() {
       return cursoRepositorio.findAll()
       .stream()
       .map(cursoMapper::toDTO) 
       .collect(Collectors.toList());// Retorna uma lista contendo o curso criado
    }

    // Método para buscar um curso pelo ID
      public CursoDTO buscaId(@PathVariable @NotNull @Positive Long id) {
        return cursoRepositorio.findById(id).map(cursoMapper::toDTO).orElseThrow(() -> new RecordNotfoundException(id)); 
        // Retorna o curso encontrado ou lança uma exceção se não encontrado
    }

    // Método para criar um novo curso
     public CursoDTO inserir(@RequestBody @Valid @NotNull CursoDTO curso){
        return cursoMapper.toDTO(cursoRepositorio.save(cursoMapper.toEntity(curso))); //retorna o status 201 de objeto criado
    }

    // Método para atualizar um curso existente
    public CursoDTO atualizar(@NotNull @Positive Long id, @Valid CursoDTO curso){
        return cursoRepositorio.findById(id)
                .map(cursoExistente -> {
                    cursoExistente.setNome(curso.nome());
                    cursoExistente.setCategoria(curso.categoria());
                 return cursoMapper.toDTO(cursoRepositorio.save(cursoExistente)); // Retorna o curso atualizado
                    
                }).orElseThrow(() -> new RecordNotfoundException(id)); // Retorna o curso atualizado ou lança uma exceção se não encontrado
    }

    // Método para deletar um curso existente
    public void deletar(@PathVariable @NotNull @Positive Long id) {
         cursoRepositorio.delete(cursoRepositorio.findById(id).orElseThrow(() -> new RecordNotfoundException(id)));
         // Deleta o curso encontrado ou lança uma exceção se não encontrado
    }


}//chave que fecha a classe CursoService
