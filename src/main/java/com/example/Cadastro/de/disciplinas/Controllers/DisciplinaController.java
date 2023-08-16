package com.example.Cadastro.de.disciplinas.Controllers;

import com.example.Cadastro.de.disciplinas.DTOS.DisciplinaDTO;
import com.example.Cadastro.de.disciplinas.Exceptions.ComentarioInvalidoException;
import com.example.Cadastro.de.disciplinas.Exceptions.DisciplinaInvalidaException;
import com.example.Cadastro.de.disciplinas.Models.Disciplina;
import com.example.Cadastro.de.disciplinas.Services.ComentarioDTO;
import com.example.Cadastro.de.disciplinas.Services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplinaController {

    private DisciplinaService disciplinas;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinas = disciplinaService;
    }

    @PostMapping("/disciplinas")
    public ResponseEntity<Disciplina> adicionarDisciplina(@RequestBody DisciplinaDTO disc) throws DisciplinaInvalidaException {
        return ResponseEntity.ok(disciplinas.adicionarDisciplina(new Disciplina(disc.getNome())));
    }
    @GetMapping("/disciplinas")
    public  ResponseEntity<List<Disciplina>> listarDisciplinas(){
        return ResponseEntity.ok(disciplinas.getDisciplinas());
    }

    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<Disciplina> getDisciplina(@PathVariable("id") long id) throws DisciplinaInvalidaException {
        return ResponseEntity.ok(disciplinas.getDisciplina(id));
    }

    @PutMapping("/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> atualizarNome(@PathVariable("id") long id, @RequestBody DisciplinaDTO d) throws DisciplinaInvalidaException {
        return ResponseEntity.ok(disciplinas.mudarNome(id, d.getNome()));
    }

    @PutMapping("/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> atualizarNota(@PathVariable("id") long id, @RequestBody DisciplinaDTO d) throws Exception {
        return ResponseEntity.ok(disciplinas.mudarNota(id, d.getNota()));
    }

    @DeleteMapping("/disciplinas/{id}")
    public ResponseEntity<Disciplina> removerDisciplina(@PathVariable("id") long id) throws DisciplinaInvalidaException {
        return ResponseEntity.ok(disciplinas.removerDisciplina(disciplinas.getDisciplina(id)));
    }

    @GetMapping("/disciplinas/ranking")
    public ResponseEntity<List<Disciplina>> ranking(){
        return ResponseEntity.ok(disciplinas.ranking());
    }

    @PutMapping("/disciplinas/{id}/comentario")
    public ResponseEntity<Disciplina> adicionarComentario(@PathVariable("id") long id, @RequestBody ComentarioDTO comentario) throws ComentarioInvalidoException, DisciplinaInvalidaException {
        return ResponseEntity.ok(disciplinas.adicionarComentario(id, comentario));
    }

    @PutMapping("/disciplinas/{id}/like")
    public ResponseEntity<Disciplina> adicionarLikes(@PathVariable("id") long id) throws DisciplinaInvalidaException {
        return ResponseEntity.ok(disciplinas.adicionarLike(id));
    }

}
