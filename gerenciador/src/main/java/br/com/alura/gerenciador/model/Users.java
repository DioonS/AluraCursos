package br.com.alura.gerenciador.model;

public class Users {
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean referente(String login, String senha) {
        if (!this.login.equals(login)) {
            return false;
        }
        if (!this.senha.equals(senha)) {
            return false;
        }

        return true;
    }
}
