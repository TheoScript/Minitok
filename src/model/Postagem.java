package model;

import java.time.LocalDate;

public class Postagem {
    private int idPostagem;
    private int usuarioId;
    private String conteudo;
    private LocalDate dataPostagem;

    private Postagem(int usuarioId,String conteudo){
        this.usuarioId= usuarioId;
        this.conteudo = conteudo;
    }

    private Postagem(int idPostagem,int usuarioId, String conteudo, LocalDate dataPostagem){
        this.idPostagem = idPostagem;
        this.usuarioId = usuarioId;
        this.conteudo = conteudo;
        this.dataPostagem = dataPostagem;
    }

    //get e set's
    public int getIdPostagem(){
        return idPostagem;
    }
    public void setIdPostagem(int idPostagem){
        this.idPostagem = idPostagem;
    }

    public int getUsuarioId(){
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId){
        this.usuarioId = usuarioId;
    }

    public String getConteudo(){
        return conteudo;
    }
    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public LocalDate getDataPostagem(){
        return dataPostagem;
    }
}



