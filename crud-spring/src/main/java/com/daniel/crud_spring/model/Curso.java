package com.daniel.crud_spring.model;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;
import com.daniel.crud_spring.enums.Categoria;
import com.daniel.crud_spring.enums.Status;
import com.daniel.crud_spring.enums.conversores.CategoriaConversor;
import com.daniel.crud_spring.enums.conversores.StatusConversor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
   // @Length(min = 3, max = 100) // Limita o tamanho do campo entre 5 e 100 caracteres
  //  @Pattern(regexp = "Back-end|Front-end") // Valida o padrão do campo
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoriaConversor.class)
    private Categoria categoria;

    @NotNull
 //  @Length(max = 100) // Limita o tamanho do campo entre 5 e 100 caracteres
   // @Pattern(regexp = "Ativo|Inativo") // Valida o padrão do campo
    @Column(length = 10,nullable = false)
    @Convert(converter = StatusConversor.class)
    private Status status = Status.ATIVO; // Campo para armazenar o status do curso, sem validação específica
 
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "curso") // Define o relacionamento um-para-muitos com a entidade Aula
    private List<Aula> aulas = new ArrayList<>(); // Lista de aulas associadas ao curso

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

public Categoria getCategoria() {
    return categoria;
}

public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
}

public Status getStatus() {
    return status;
}

public void setStatus(Status status) {
    this.status = status;
}

    
}
