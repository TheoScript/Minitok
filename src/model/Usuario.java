package model;
import java.lang.classfile.attribute.ModuleMainClassAttribute;
import java.time.LocalDate;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCadastro;

    private Usuario(String nome,String email, String senha){
        this.nome= nome;
        this.email = email;
        this.senha = senha;
    }

    private Usuario(int idUsuario,String nome,String email, String senha, LocalDate dataCadasto){
        this.idUsuario = idUsuario;
        this.nome= nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    //get e set's
    public int getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public LocalDate getDataCadastro(){
        return dataCadastro;
    }

    //Metodos

    public void cadastrarUsuario(String nome, String email, String senha){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public void atualizarUsuario(String nome, String email, String senha){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }
}