package com.daniel.crud_spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.daniel.crud_spring.model.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
