package br.com.senai.cursosBackend.curso;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCurso (

        @Size(min = 2)
        String nome,
        Periodo periodo
){
}
