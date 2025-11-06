package com.knight.estoque.modelos;

public class Usuario {

    private String nome;
    private String login;
    private String senha;

    public String getNome() {
        if (nome != null)
			return nome;
        return "";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        if (nome != null)
			return login;
        return "";
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        if (nome != null)
			return senha;
        return "";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
