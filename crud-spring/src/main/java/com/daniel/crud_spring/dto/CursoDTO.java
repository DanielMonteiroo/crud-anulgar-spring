package com.daniel.crud_spring.dto;
import org.hibernate.validator.constraints.Length;

import com.daniel.crud_spring.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO
(@JsonProperty("_id")Long id, 
 @NotBlank @NotNull @Length(min = 3, max = 100) String nome, 
 @NotNull Categoria categoria) {

    public CursoDTO(Long id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;

    }

}
