package br.com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {
    private Integer id;
    private String nome;
    private Date dataAbertura = new Date();

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
