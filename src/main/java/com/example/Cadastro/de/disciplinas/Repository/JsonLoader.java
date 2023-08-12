package com.example.Cadastro.de.disciplinas.Repository;
import com.example.Cadastro.de.disciplinas.Exceptions.DisciplinaInvalidaException;
import com.example.Cadastro.de.disciplinas.Models.Disciplina;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader implements FileLoader {
    @Override
    public List<Disciplina> loadFile(String fileName) {
        File arquivo = new File(fileName);
        ObjectMapper objMp = new ObjectMapper();
        try{
            JsonNode json = objMp.readTree(arquivo);
            List<Disciplina> lista = new ArrayList<>();
            for(String nome : json.findValuesAsText("nome"))
                lista.add(new Disciplina(nome));
            return lista;
        }catch(IOException | DisciplinaInvalidaException e){
            return null;
        }
    }
}
