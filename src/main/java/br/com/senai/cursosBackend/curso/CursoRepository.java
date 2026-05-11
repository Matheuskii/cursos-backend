package br.com.senai.cursosBackend.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAllByAtivoTrue();

    Optional<Curso> findByIdAndAtivoTrue(Long id);
}
