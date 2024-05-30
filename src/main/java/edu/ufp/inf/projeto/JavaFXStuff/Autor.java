package edu.ufp.inf.projeto.JavaFXStuff;


import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private String nomeCurto;
    private String filiacao;
    private int ORCID;
    private int cienciaID;
    private int googleScholarID;
    private int scopusAuthorID;


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

    /**
     * get Nome do Autor
     * @return nome autor
     */
    public String getNome() {
        return nome;
    }

    /**
     * get NomeCurto do Autor
     * @return nome curto do autor
     */
    public String getNomeCurto() {
        return nomeCurto;
    }

    /**
     * get Filiacao do Autor
     * @return filiação do autor
     */
    public String getFiliacao() {
        return filiacao;
    }

    /**
     * get ORCID do Autor
     * @return ORCID do autor
     */
    public int getORCID() {
        return ORCID;
    }

    /**
     * get CienciaID do Autor
     * @return cienciaID do autor
     */
    public int getCienciaID() {
        return cienciaID;
    }

    /**
     * get GoogleScholarID do Autor
     * @return googleScholarID do autor
     */
    public int getGoogleScholarID() {
        return googleScholarID;
    }

    /**
     * getScopusAuthorID do Autor
     * @return scopusAuthorID do autor
     */
    public int getScopusAuthorID() {
        return scopusAuthorID;
    }

    /**
     * set Nome do Autor
     * @param nome do autor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Set Nome Curto do autor
     * @param nomeCurto do autor
     */
    public void setNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    /**
     * set Filiacao do Autor
     * @param filiacao do autor
     */
    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    /**
     * Set ORCID do autor
     * @param ORCID do autor
     */
    public void setORCID(int ORCID) {
        this.ORCID = ORCID;
    }

    /**
     * Set CienciaID do autor
     * @param cienciaID do autor
     */
    public void setCienciaID(int cienciaID) {
        this.cienciaID = cienciaID;
    }

    /**
     * set GoogleScholarID do Autor
     * @param googleScholarID do autor
     */
    public void setGoogleScholarID(int googleScholarID) {
        this.googleScholarID = googleScholarID;
    }

    /**
     * set ScopusAuthorID do Autor
     * @param scopusAuthorID do autor
     */
    public void setScopusAuthorID(int scopusAuthorID) {
        this.scopusAuthorID = scopusAuthorID;
    }

    /**
     * Função para Adicionar Autor
     * @param nome do autor
     * @param nomeCurto do autor
     * @param filiacao do autor
     * @param ORCID do autor
     * @param cienciaID do autor
     * @param googleScholarID do autor
     * @param scopusAuthorID do autor
     * @return do autor
     */
    public static Autor adicionarAutor(String nome, String nomeCurto, String filiacao, int ORCID, int cienciaID, int googleScholarID, int scopusAuthorID) {
        Autor autor = new Autor(nome, nomeCurto, filiacao,  ORCID,  cienciaID,  googleScholarID,  scopusAuthorID);
        autores.add(autor);
        return autor;
    }

    /**
     * Função para listar artigos de um dado autor
     * @return de artigos
     */
    public List<Artigo> getArtigos() {
        return artigos;
    }

    /**
     * Adicionar Artigo a um autor
     * @param artigo de artigos
     */
    public void adicionarArtigo(Artigo artigo) {
        artigos.add(artigo);
    }

    /**
     * Remover Artigo pertencente a um dado Autor
     * @param artigo de artigos
     */
    public void removerArtigo(Artigo artigo) {
        artigos.remove(artigo);
    }

    /**
     * Função para Remover Autor
     * @param autor de artigos
     */
    public static void removerAutor(Autor autor) {
        autores.remove(autor);
    }

    /**
     * Função para atualizar autor
     * @param nome do Autor
     * @param nomeCurto do Autor
     * @param filiacao do Autor
     * @param ORCID do Autor
     * @param cienciaID do Autor
     * @param googleScholarID do Autor
     * @param scopusAuthorID do Autor
     */
    public void atualizarAutor(String nome, String nomeCurto, String filiacao, int ORCID, int cienciaID, int googleScholarID, int scopusAuthorID) {
        this.setNome(nome);
        this.setNomeCurto(nomeCurto);
        this.setFiliacao(filiacao);
        this.setORCID(ORCID);
        this.setCienciaID(cienciaID);
        this.setGoogleScholarID(googleScholarID);
        this.setScopusAuthorID(scopusAuthorID);
    }

    /**
     * Função para Método obter a lista de autores (opcional)
     * @return de Autores
     */
    public static List<Autor> getAutores() {
        return autores;
    }

    /**
     * Função toString alterada para dar print do requisitado no projeto
     * @return toString
     */
    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", orcid='" + ORCID + '\'' +
                '}';
    }
}