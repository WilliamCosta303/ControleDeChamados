package com.github.williamcosta303.modelo;

public class Login {
    private int codigo, privilegio, codigoEquipe;
    private String nome, senha;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }

    public int getCodigoEquipe() {
        return codigoEquipe;
    }

    public void setCodigoEquipe(int codigoEquipe) {
        this.codigoEquipe = codigoEquipe;
    }
    
    
    
    
}
