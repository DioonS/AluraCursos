package br.com.alura.loja.model;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    //Chave composta
    @EmbeddedId
   private CategoriaId id;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "pessoa");
    }

    public String getNome() {
        return this.id.getNome();
    }

}
