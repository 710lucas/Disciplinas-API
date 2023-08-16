package com.example.Cadastro.de.disciplinas.Models;

import com.example.Cadastro.de.disciplinas.Exceptions.ComentarioInvalidoException;
import com.example.Cadastro.de.disciplinas.Exceptions.DisciplinaInvalidaException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="DISCIPLINA")
public class Disciplina implements Comparable<Disciplina>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @ElementCollection
    private List<Double> notas = new ArrayList<>();
    @OneToMany
    @JsonIgnoreProperties("disciplina")
    private List<Comentario> comentarios = new ArrayList<>();
    private int likes;


    public Disciplina(String nome) throws DisciplinaInvalidaException {
        if(nome == null || nome.replaceAll(" ", "").equals(""))
            throw new DisciplinaInvalidaException("o nome informado é inválido");
        setNome(nome);
    }

    public Disciplina(){

    }

    public void addNota(Double nota) throws Exception {
        if(nota == null || nota > 10 || nota < 0)
            throw new Exception("Nota informada é invalida");
        notas.add(nota);
    }

    public void setNotas(List<Double> notas){
        this.notas = notas;
    }

    public void setNome(String nome){
       this.nome = nome;
    }

    public void addComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes(){
        return likes;
    }

    public double getMedia(){
        double total = 0;
        for(Double d : notas)
            total+=d;
        return total/notas.size();
    }

    public List<Comentario> getComentarios(){
        return comentarios;
    }

    public List<Comentario> getComentariosPorAutor(String nome) throws ComentarioInvalidoException {
        List<Comentario> comentarios = new ArrayList<>();
        for(Comentario c : this.comentarios)
            if(c.getAutor().getNome().equals(nome))
                comentarios.add(c);
        if(comentarios.size() == 0)
            throw new ComentarioInvalidoException("Não existem comentarios com o usuario com nome: "+nome+" nesta disciplina");
        return comentarios;
    }

    public List<Double> getNotas(){
        return notas;
    }

    public String getNome(){
        return nome;
    }

    public long getId(){
        return id;
    }

    public void adicionarLikes(){
        likes++;
    }

    public void removerLikes(){
        likes--;
    }

    @Override
    public int compareTo(Disciplina o) {
        Disciplina d = (Disciplina) o;
        return Double.compare(getMedia(), o.getMedia());
    }
}

