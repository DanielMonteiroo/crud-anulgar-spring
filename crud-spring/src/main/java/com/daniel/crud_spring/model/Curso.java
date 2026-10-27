package com.daniel.crud_spring.model;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "cursos") // Especifica o nome da tabela no banco de dados
@SQLDelete(sql = "UPDATE cursos SET status = 'Inativo' WHERE id = ?") // Define a ação de exclusão lógica
@SQLRestriction("status = 'Ativo'") // Define um filtro para buscar apenas cursos ativos
public class Curso {

    @Id // Indica que o campo é a chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Geração automática do ID
    private Long id;

    @NotBlank // Indica que o campo não pode ser vazio
    @NotNull // Indica que o campo não pode ser nulo
    @Length(min = 3, max = 10)
    @Column(length = 100,nullable = false) // Especifica detalhes da coluna
    private String nome;

    @NotNull
    @Length(min = 3, max = 100) // Limita o tamanho do campo entre 5 e 100 caracteres
    @Pattern(regexp = "Back-end|Front-end") // Valida o padrão do campo
    @Column(length = 10,nullable = false)
    private String categoria;

    @NotNull
    @Length(max = 100) // Limita o tamanho do campo entre 5 e 100 caracteres
    @Pattern(regexp = "Ativo|Inativo") // Valida o padrão do campo
    @Column(length = 10,nullable = false)
    private String status = "Ativo"; // Campo para armazenar o status do curso, sem validação específica

// Getters e Setters

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCategoria() {
    return categoria;
}

public void setCategoria(String categoria) {
    this.categoria = categoria;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

    
}
