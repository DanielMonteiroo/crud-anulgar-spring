package com.daniel.crud_spring.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Gera getters, setters, toString, equals e hashCode automaticamente
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "cursos") // Especifica o nome da tabela no banco de dados
public class Curso {

    @Id // Indica que o campo é a chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Geração automática do ID
    private Long id;

    @Column(length = 200,nullable = false) // Especifica detalhes da coluna
    private String nome;

    @Column(length = 20,nullable = false)
    private String categoria;


    
}
