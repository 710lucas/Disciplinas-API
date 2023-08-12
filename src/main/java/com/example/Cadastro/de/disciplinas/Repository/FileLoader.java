package com.example.Cadastro.de.disciplinas.Repository;

import java.util.List;

public interface FileLoader<Tipo> {

    public List<Tipo> loadFile(String fileName);

}
