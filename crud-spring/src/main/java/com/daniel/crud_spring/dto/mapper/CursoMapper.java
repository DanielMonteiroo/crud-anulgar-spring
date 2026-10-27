package com.daniel.crud_spring.dto.mapper;
import org.springframework.stereotype.Component;

import com.daniel.crud_spring.dto.CursoDTO;
import com.daniel.crud_spring.model.Curso;

@Component 
public class CursoMapper {

    // Converte um objeto CursoDTO em um objeto Curso
    public CursoDTO toDTO(Curso curso) {

        if (curso == null) {
            return null; // Retorna null se o curso for nulo
        }

        return new CursoDTO(curso.getId(), curso.getNome(), curso.getCategoria());
    }


    // Converte um objeto Curso em um objeto CursoDTO
    public Curso toEntity(CursoDTO curso2) {
        Curso curso = new Curso();

        if (curso2 == null) {
            return null; // Retorna null se o cursoDTO for nulo
        }

        // Se o ID do cursoDTO não for nulo, define o ID do curso
        if (curso2.id() != null) {
            curso.setId(curso2.id());
        }
        curso.setNome(curso2.nome());
        curso.setCategoria(curso2.categoria());

        return curso; // Retorna o objeto Curso convertido
    }
}
