package com.daniel.crud_spring.dto;
import java.util.List;
import org.hibernate.validator.constraints.Length;
import com.daniel.crud_spring.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO
(@JsonProperty("_id")Long id, 
 @NotBlank @NotNull @Length(min = 3, max = 100) String nome, 
 @NotNull Categoria categoria,
 List<AulaDTO> aulas) {
}
