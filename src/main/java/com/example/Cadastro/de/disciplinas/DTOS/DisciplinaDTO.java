package com.example.Cadastro.de.disciplinas.DTOS;

import com.example.Cadastro.de.disciplinas.Models.Comentario;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDTO {

    private long id;
    private String nome;
    private List<Double> notas;
    private List<Comentario> comentarios;
    private int likes;

    public DisciplinaDTO(long id, String nome, List<Double> notas, List<Comentario> comentarios, int likes) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
        this.comentarios = comentarios;
        this.likes = likes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setNota(double nota){
        this.notas = new ArrayList<>();
        this.notas.add(nota);
    }

    public double getNota(){
        return this.notas.get(0);
    }

    public int getLikes() {
        return likes;
    }
}
