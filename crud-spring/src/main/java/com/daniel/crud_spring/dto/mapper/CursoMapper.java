package com.daniel.crud_spring.dto.mapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.daniel.crud_spring.dto.AulaDTO;
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
        List<AulaDTO> aulasDTO = curso.getAulas()
                .stream()
                .map(aula -> new AulaDTO(aula.getId(), aula.getNome(), aula.getLinkUrl()))
                .collect(Collectors.toList()); // Converte a lista de aulas do Curso para uma lista de AulaDTO
        return new CursoDTO(curso.getId(), curso.getNome(), curso.getCategoria(), aulasDTO); // Cria um novo CursoDTO com os valores do Curso
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

