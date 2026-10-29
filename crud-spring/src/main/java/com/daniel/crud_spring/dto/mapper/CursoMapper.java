package com.daniel.crud_spring.dto.mapper;
import org.springframework.stereotype.Component;
import com.daniel.crud_spring.dto.CursoDTO;
import com.daniel.crud_spring.enums.Categoria;
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
        curso.setCategoria(convertCategoria(curso2.categoria())); // Converte a categoria do cursoDTO para a entidade Curso

        return curso; // Retorna o objeto Curso convertido
    }

    // Converte a categoria do cursoDTO para a entidade Curso
    public Categoria convertCategoria(Categoria valor) {
        if (valor == null) {
            return null; // Retorna null se o cursoDTO ou a categoria for nula
        }
        return switch (valor.getValor()) {
            case "Front-end" -> Categoria.FRONT_END;
            case "Back-end" -> Categoria.BACK_END;
            default -> throw new IllegalArgumentException("Categoria inválida: " + valor);
        };
    }
  
}

