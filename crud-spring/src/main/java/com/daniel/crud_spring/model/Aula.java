package com.daniel.crud_spring.model;
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
    private Curso curso; // Relacionamento muitos-para-um com a entidade Curso
}
