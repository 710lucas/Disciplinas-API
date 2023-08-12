package com.example.Cadastro.de.disciplinas.Models;

import com.example.Cadastro.de.disciplinas.Exceptions.UsuarioInvalidoException;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) throws UsuarioInvalidoException {
        if(nome == null || nome.replaceAll(" ", "").equals("") || email == null || email.contains(" ") || email.equals("") || senha == null || senha.replaceAll(" ", "").equals(""))
            throw new UsuarioInvalidoException("Houve um erro ao adicionar o usuário");
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha(){
        return senha;
    }

    public String getEmail(){
        return email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
