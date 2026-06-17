package objetos;

public class Serie {

    private int id;
    private String nome;
    private String status;
    private String estreia;
    private String fim;
    private double nota;
    private String emissora;
    private String generos;
    private String sumario;
    private String idioma;

    
    public Serie() {
    }


    public Serie(int id, String nome, String status, String estreia, String fim, double nota, String emissora,
            String generos, String sumario) {
        this(id, nome, status, estreia, fim, nota, emissora, generos, sumario, "Desconhecido");
    }

    public Serie(int id, String nome, String status, String estreia, String fim, double nota, String emissora,
            String generos, String sumario, String idioma) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.estreia = estreia;
        this.fim = fim;
        this.nota = nota;
        this.emissora = emissora;
        this.generos = generos;
        this.sumario = sumario;
        this.idioma = idioma;
    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getStatus() {
        return status;
    }


    public String getEstreia() {
        return estreia;
    }


    public String getFim() {
        return fim;
    }


    public double getNota() {
        return nota;
    }


    public String getEmissora() {
        return emissora;
    }


    public String getGeneros() {
        return generos;
    }


    public String getSumario() {
        return sumario;
    }


    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    @Override
    public String toString() {
        return "Serie [nome=" + nome + ", status=" + status + ", nota=" + nota + "]";
    }

    

}
