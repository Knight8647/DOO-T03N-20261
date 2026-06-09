package com.erick.tvtracker.service;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import com.erick.tvtracker.model.Serie;
import com.erick.tvtracker.model.Usuario;

public class UsuarioService {
    private Usuario usuario;
    private final PersistenciaService persistencia;
    public UsuarioService() {
        this.persistencia = new PersistenciaService();
        carregarOuCriar();
    }

    private void carregarOuCriar() {
        try {
            Usuario carregado = persistencia.carregar();
            if (carregado != null) {
                this.usuario = carregado;
            } else {
                this.usuario = new Usuario();
            }
        } catch (IOException e) {
            this.usuario = new Usuario();
        }
    }

    public void salvar() throws IOException {
        persistencia.salvar(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setNomeUsuario(String nome) {
        usuario.setNome(nome);
    }

    public void adicionarFavorito(Serie serie) {
        usuario.adicionarFavorito(serie);
    }
    public void removerFavorito(Serie serie) {
        usuario.removerFavorito(serie);
    }

    public void adicionarAssistida(Serie serie) {
        usuario.adicionarAssistida(serie);
    }
    public void removerAssistida(Serie serie) {
        usuario.removerAssistida(serie);
    }

    public void adicionarQueroAssistir(Serie serie) {
        usuario.adicionarQueroAssistir(serie);
    }
    public void removerQueroAssistir(Serie serie) {
        usuario.removerQueroAssistir(serie);
    }

    public void ordenarPorNome(List<Serie> lista) {
        lista.sort(Comparator.comparing(Serie::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public void ordenarPorNota(List<Serie> lista) {
        lista.sort(Comparator.comparingDouble(Serie::getRating).reversed());
    }

    public void ordenarPorStatus(List<Serie> lista) {
        lista.sort(Comparator.comparing(Serie::getStatus, String.CASE_INSENSITIVE_ORDER));
    }

    public void ordenarPorDataEstreia(List<Serie> lista) {
        lista.sort(Comparator.comparing( serie -> serie.getPremiered() == null ? "" : serie.getPremiered()));
    }
}