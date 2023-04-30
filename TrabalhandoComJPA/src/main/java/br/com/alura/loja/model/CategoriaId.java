package br.com.alura.loja.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

// Chave composta
@Embeddable
public class CategoriaId implements Serializable {

    private static final long serialVersionUID = -236416752171843896L;
    private String nome;
    private String tipo;

    public CategoriaId() {}

    public CategoriaId(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
