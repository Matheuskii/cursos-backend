package br.com.senai.cursosBackend.controllers;


import br.com.senai.cursosBackend.curso.*;
import jakarta.validation.Valid;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    CursoRepository repository;

    @GetMapping
    private ResponseEntity<List<DadosListagemCurso>> listarCursos(){
        List<Curso> cursos = repository.findAllByAtivoTrue();
        List<DadosListagemCurso> cursosDTO =  cursos.stream().map(DadosListagemCurso::new).toList();

        return ResponseEntity.ok().body(cursosDTO);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DadosDetalhesCurso> listarCursosPorId(@PathVariable Long id){
        Optional<Curso> curso = Optional.of(repository.findByIdAndAtivoTrue(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado esse curso")));
        DadosDetalhesCurso cursoDTO = new DadosDetalhesCurso(curso);



        return ResponseEntity.ok().body(cursoDTO);
    }


}