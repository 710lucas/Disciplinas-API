package com.example.Cadastro.de.disciplinas.Models;

import com.example.Cadastro.de.disciplinas.Exceptions.ComentarioInvalidoException;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "COMENTARIO")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Usuario autor;
    private String conteudo;
    private Disciplina disciplina;

    public Comentario(Usuario autor, String conteudo, Disciplina disciplina) throws ComentarioInvalidoException {
        if(autor == null || conteudo == null || conteudo.replaceAll(" ", "").equals("") || disciplina == null)
            throw new ComentarioInvalidoException("O comentario informado é invalido");
        setAutor(autor);
        setConteudo(conteudo);
        setDisciplina(disciplina);
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Usuario getAutor(){
        return autor;
    }

    public String getConteudo(){
        return conteudo;
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }

    public String toString(){
        return "Comentario {nome="+autor.getNome()+"; conteudo="+conteudo+"; disciplina="+disciplina.getNome()+"\n";
    }
}
