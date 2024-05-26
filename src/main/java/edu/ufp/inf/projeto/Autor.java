package edu.ufp.inf.projeto;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Autor {
    private String nome;
    private String nomeCurto;
    private String filiacao;
    private int ORCID;
    private int cienciaID;
    private int googleScholarID;
    private int scopusAuthorID;

    // Lista estática de autores
    private static List<Autor> autores = new ArrayList<>();
    private List<Artigo> artigos;
    public Autor(String nome, String nomeCurto, String filiacao,int ORCID,int cienciaID,int googleScholarID,int scopusAuthorID) {
        this.nome = nome;
        this.nomeCurto = nomeCurto;
        this.filiacao = filiacao;
        this.ORCID = ORCID;
        this.cienciaID = cienciaID;
        this.googleScholarID = googleScholarID;
        this.scopusAuthorID = scopusAuthorID;
        this.artigos = new ArrayList<>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getNomeCurto() {
        return nomeCurto;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public int getORCID() {
        return ORCID;
    }

    public int getCienciaID() {
        return cienciaID;
    }

    public int getGoogleScholarID() {
        return googleScholarID;
    }

    public int getScopusAuthorID() {
        return scopusAuthorID;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public void setORCID(int ORCID) {
        this.ORCID = ORCID;
    }

    public void setCienciaID(int cienciaID) {
        this.cienciaID = cienciaID;
    }

    public void setGoogleScholarID(int googleScholarID) {
        this.googleScholarID = googleScholarID;
    }

    public void setScopusAuthorID(int scopusAuthorID) {
        this.scopusAuthorID = scopusAuthorID;
    }

    // Métodos para adicionar, remover e atualizar autores
    public static Autor adicionarAutor(String nome, String nomeCurto, String filiacao, int ORCID, int cienciaID, int googleScholarID, int scopusAuthorID) {
        Autor autor = new Autor(nome, nomeCurto, filiacao,  ORCID,  cienciaID,  googleScholarID,  scopusAuthorID);
        autores.add(autor);
        return autor;
    }
    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void adicionarArtigo(Artigo artigo) {
        artigos.add(artigo);
    }

    public void removerArtigo(Artigo artigo) {
        artigos.remove(artigo);
    }

    public static void removerAutor(Autor autor) {
        autores.remove(autor);
    }

    public void atualizarAutor(String nome, String nomeCurto, String filiacao, int ORCID, int cienciaID, int googleScholarID, int scopusAuthorID) {
        this.setNome(nome);
        this.setNomeCurto(nomeCurto);
        this.setFiliacao(filiacao);
        this.setORCID(ORCID);
        this.setCienciaID(cienciaID);
        this.setGoogleScholarID(googleScholarID);
        this.setScopusAuthorID(scopusAuthorID);
    }

    // Método para obter a lista de autores (opcional)
    public static List<Autor> getAutores() {
        return autores;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", orcid='" + ORCID + '\'' +
                '}';
    }
}