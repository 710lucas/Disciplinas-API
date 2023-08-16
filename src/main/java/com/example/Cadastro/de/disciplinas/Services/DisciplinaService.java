package com.example.Cadastro.de.disciplinas.Services;


import com.example.Cadastro.de.disciplinas.Exceptions.ComentarioInvalidoException;
import com.example.Cadastro.de.disciplinas.Exceptions.DisciplinaInvalidaException;
import com.example.Cadastro.de.disciplinas.Models.Comentario;
import com.example.Cadastro.de.disciplinas.Models.Disciplina;
import com.example.Cadastro.de.disciplinas.Repository.ComentarioRepository;
import com.example.Cadastro.de.disciplinas.Repository.DisciplinaRepository;
import com.example.Cadastro.de.disciplinas.Repository.FileLoader;
import com.example.Cadastro.de.disciplinas.Repository.JsonLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DisciplinaService {


    private DisciplinaRepository repositorio;
    private ComentarioRepository comentarioRepo;
    @Autowired
    public DisciplinaService(DisciplinaRepository repositorio, ComentarioRepository comentarioRepo){
        this.repositorio = repositorio;
        FileLoader loader = new JsonLoader();
        if(repositorio.count() == 0)
            for(Disciplina d : (List<Disciplina>) loader.loadFile("Disciplinas.Json"))
                repositorio.save(d);
        this.comentarioRepo = comentarioRepo;

    }


    public Disciplina adicionarDisciplina(Disciplina d){
        repositorio.save(d);
        return d;
    }

    public Disciplina getDisciplina(long id) throws DisciplinaInvalidaException {
        if(repositorio.findById(id).isPresent())
            return repositorio.findById(id).get();
        throw new DisciplinaInvalidaException("O id informado é inválido");
    }

    public Disciplina getDisciplina(String nome) throws DisciplinaInvalidaException {
        for(Disciplina t : repositorio.findAll())
            if(t.getNome().equals(nome))
                return t;
        throw new DisciplinaInvalidaException("O nome informado é inválido");
    }

    public Disciplina removerDisciplina(Disciplina d){
        Disciplina a = d;
        repositorio.delete(d);
        return a;
    }

    public Disciplina mudarNome(long id, String nome) throws DisciplinaInvalidaException {
        getDisciplina(id).setNome(nome);
        repositorio.save(getDisciplina(id));
        return getDisciplina(id);
    }

    public Disciplina mudarNota(long id, double nota) throws Exception {
        getDisciplina(id).addNota(nota);
        repositorio.save(getDisciplina(id));
        return getDisciplina(id);
    }

    public List<Disciplina> ranking(){
        List<Disciplina> rankeadas = repositorio.findAll();
        Collections.sort(rankeadas);
        Collections.reverse(rankeadas);
        return rankeadas;
    }

    public List<Disciplina> getDisciplinas(){
        return repositorio.findAll();
    }

    public Disciplina adicionarComentario(long id, ComentarioDTO coment) throws DisciplinaInvalidaException, ComentarioInvalidoException {
        coment.setDisciplina(getDisciplina(id));
        Comentario comentario = new Comentario(coment.getAutor(), coment.getConteudo(), coment.getDisciplina());
        comentarioRepo.save(comentario);
        getDisciplina(id).addComentario(comentario);
        repositorio.save(getDisciplina(id));
        return getDisciplina(id);
    }
}
