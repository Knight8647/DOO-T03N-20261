package com.erick.tvtracker.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.erick.tvtracker.model.Serie;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TvMazeService {

    private static final String BASE_URL = "https://api.tvmaze.com";

    // cliente HTTP reutilizável para todas as requisições
    private final HttpClient httpClient;

    // responsável por converter JSON em objetos Java
    private final ObjectMapper objectMapper;

    public TvMazeService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    // busca séries pelo nome digitado pelo usuário
    public List<Serie> buscarPorNome(String nome) throws IOException, InterruptedException {
        String url = BASE_URL + "/search/shows?q=" + nome.replace(" ", "%20");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        List<Serie> series = new ArrayList<>();
        JsonNode root = objectMapper.readTree(response.body());

        // a API retorna uma lista de objetos com campo "show" dentro de cada um
        for (JsonNode item : root) {
            JsonNode show = item.get("show");
            if (show != null) {
                series.add(parseSerie(show));
            }
        }
        return series;
    }

    // converte um nó JSON da API em um objeto Serie
    private Serie parseSerie(JsonNode show) {
        int id = show.path("id").asInt(); //Esses desconhecidos e N/A são para o caso de não ter 
        String name = show.path("name").asText("Desconhecido"); //esses campos na API
        String language = show.path("language").asText("Desconhecido"); //Assim não dá erro pra salvar por causa
        String status = show.path("status").asText("Desconhecido"); //do construtor que exige esses campos
        String premiered = show.path("premiered").asText("N/A");
        String ended = show.path("ended").asText("N/A");

        // a nota fica dentro de um objeto "rating" com campo "average"
        double rating = 0.0;
        JsonNode ratingNode = show.path("rating");
        if (!ratingNode.isMissingNode() && !ratingNode.path("average").isNull()) {
            rating = ratingNode.path("average").asDouble();
        }

        // o nome da emissora fica dentro do objeto "network"
        String networkName = "Desconhecido";
        JsonNode networkNode = show.path("network");
        if (!networkNode.isMissingNode() && !networkNode.isNull()) {
            networkName = networkNode.path("name").asText("Desconhecido");
        }

        // os gêneros vêm como array, tem que separar em string por virgula. AULA DO SAMUEL DO DIA 29 do 5 SENAO ME ENGANO
        StringBuilder genresBuilder = new StringBuilder();
        JsonNode genresNode = show.path("genres");
        if (genresNode.isArray()) {
            for (int i = 0; i < genresNode.size(); i++) {
                if (i > 0) genresBuilder.append(", ");
                genresBuilder.append(genresNode.get(i).asText());
            }
        }

        // a sinopse vem com tags HTML, tem que tirar pra ficar um texto legivel
        String summary = show.path("summary").asText("Sem descrição.");
        summary = summary.replaceAll("<[^>]*>", "");

        return new Serie(id, name, language, status, premiered, ended,
                rating, networkName, genresBuilder.toString(), summary);
    }
}