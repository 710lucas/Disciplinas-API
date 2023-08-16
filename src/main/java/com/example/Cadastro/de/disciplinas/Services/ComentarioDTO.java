package com.example.Cadastro.de.disciplinas.Services;

import com.example.Cadastro.de.disciplinas.Models.Disciplina;
import com.example.Cadastro.de.disciplinas.Models.Usuario;

public class ComentarioDTO {

    private long id;
    private Usuario autor;
    private String conteudo;
    private Disciplina disciplina;

    public ComentarioDTO(long id, Usuario autor, String conteudo, Disciplina disciplina) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.disciplina = disciplina;
    }

    public ComentarioDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
