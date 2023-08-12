package com.example.Cadastro.de.disciplinas.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorDeExcecoes {

    @ExceptionHandler(UsuarioInvalidoException.class)
    public ResponseEntity<String> usuarioInvalido(UsuarioInvalidoException excecao){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: "+excecao.getMessage());
    }

    @ExceptionHandler(DisciplinaInvalidaException.class)
    public ResponseEntity<String> DisciplinaInvalida(DisciplinaInvalidaException excecao){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: "+excecao.getMessage());
    }

}
