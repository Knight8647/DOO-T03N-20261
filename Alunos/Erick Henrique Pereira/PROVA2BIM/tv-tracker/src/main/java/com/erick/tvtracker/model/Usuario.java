package com.erick.tvtracker.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome; // nome do user
    private List<Serie> favoritos; // lista favoritas
    private List<Serie> assistidas; // lista assistidos
    private List<Serie> queroAssistir;// lista querer assistir

    public Usuario() {
        this.favoritos = new ArrayList<>();
        this.assistidas = new ArrayList<>();
        this.queroAssistir = new ArrayList<>();
    }

    public Usuario(String nome) {
        this.nome = nome;
        this.favoritos = new ArrayList<>();
        this.assistidas = new ArrayList<>();
        this.queroAssistir = new ArrayList<>();
    }

    public String getNome(){ 
        return nome; 
    }
    public void setNome(String nome){ 
        this.nome = nome; 
    }

    public List<Serie> getFavoritos(){ 
        return favoritos; 
    }
    public void setFavoritos(List<Serie> favoritos) { 
        this.favoritos = favoritos; 
    }

    public List<Serie> getAssistidas() { 
        return assistidas; 
    }
    public void setAssistidas(List<Serie> assistidas) { 
        this.assistidas = assistidas; 
    }

    public List<Serie> getQueroAssistir() { 
        return queroAssistir; 
    }
    public void setQueroAssistir(List<Serie> queroAssistir) {
         this.queroAssistir = queroAssistir; 
        }

    
    public void adicionarFavorito(Serie serie) {
        if (!favoritos.contains(serie)) favoritos.add(serie);
    }

    public void removerFavorito(Serie serie) {
        favoritos.remove(serie);
    }

    public void adicionarAssistida(Serie serie) {
        if (!assistidas.contains(serie)) assistidas.add(serie);
    }

    public void removerAssistida(Serie serie) {
        assistidas.remove(serie);
    }

    public void adicionarQueroAssistir(Serie serie) {
        if (!queroAssistir.contains(serie)) queroAssistir.add(serie);
    }

    public void removerQueroAssistir(Serie serie) {
        queroAssistir.remove(serie);
    }
}
