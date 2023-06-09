package br.com.alura.loja.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
@NamedQuery(name = "Produto.produtosPorCategoria", query = "SELECT p FROM Produto p WHERE p.categoria.id.nome = :nome")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Ou usar o JOINED que cria uma tabela para cada entidade (Perde em performance)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private br.com.alura.loja.model.Categoria categoria;

    public Produto() {
    }

    public Produto(String nome, String descricao, BigDecimal preco, br.com.alura.loja.model.Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public br.com.alura.loja.model.Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(br.com.alura.loja.model.Categoria categoria) {
        this.categoria = categoria;
    }

}
