package com.erick.tvtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie {

    private int id;
    private String name; // nome
    private String language; // lingua
    private String status; // estado da série, se já terminou e tals
    private String premiered; // data de estreia
    private String ended; // data do fim (null se ainda em exibição)
    private double rating; // nota da séroe
    private String networkName; // nome da emissora 
    private String genres; // gêneros da série separados por vírgula
    private String summary; //sinopse da série

    public Serie() {}

    public Serie(int id, String name, String language, String status,
                 String premiered, String ended, double rating,
                 String networkName, String genres, String summary) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.rating = rating;
        this.networkName = networkName;
        this.genres = genres;
        this.summary = summary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPremiered() { return premiered; }
    public void setPremiered(String premiered) { this.premiered = premiered; }

    public String getEnded() { return ended; }
    public void setEnded(String ended) { this.ended = ended; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getNetworkName() { return networkName; }
    public void setNetworkName(String networkName) { this.networkName = networkName; }

    public String getGenres() { return genres; }
    public void setGenres(String genres) { this.genres = genres; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    @Override
    public String toString() {
        return name + " (" + status + ") - Nota: " + rating;
    }
}