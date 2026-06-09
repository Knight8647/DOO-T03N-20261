package com.erick.tvtracker.service;
import java.io.File;
import java.io.IOException;

import com.erick.tvtracker.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersistenciaService {

    // nome do arquivo onde os dados do usuário serão salvos
    private static final String ARQUIVO = "dados.json";

    // responsável por converter objetos Java em JSON e vice-versa
    private final ObjectMapper objectMapper;

    public PersistenciaService() {
        // habilita indentação para o JSON ficar legível no arquivo
        this.objectMapper = new ObjectMapper();
    }

    // salva os dados do usuário no arquivo JSON
    public void salvar(Usuario usuario) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(ARQUIVO), usuario);
    }

    // carrega os dados do usuário a partir do arquivo JSON
    // retorna null se o arquivo não existir (primeira execução)
    public Usuario carregar() throws IOException {
        File arquivo = new File(ARQUIVO);

        // se o arquivo não existir ainda, retorna null
        if (!arquivo.exists()) {
            return null;
        }

        return objectMapper.readValue(arquivo, Usuario.class);
    }
}