package Model;

public class Serie {
    private int id;
    private String titulo;
    private String genero;
    private String descricao;
    private int temporada;

    public Serie(String titulo, String genero, String descricao, int temporada) {
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
        this.temporada = temporada;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    // toString() para exibição
    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", temporada=" + temporada +
                '}';
    }
}
