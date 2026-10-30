package com.daniel.crud_spring.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data 
@Entity
public class Aula {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String linkUrl;

    @ManyToOne(fetch = FetchType.LAZY,optional = false) // Define o relacionamento muitos-para-um com a entidade Curso
    @JoinColumn(name = "curso_id",nullable = false) // Especifica a coluna de junção para o relacionamento
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Define que a propriedade curso será ignorada na serialização para JSON, mas ainda poderá ser definida na desserialização
    private Curso curso; // Relacionamento muitos-para-um com a entidade Curso
}
