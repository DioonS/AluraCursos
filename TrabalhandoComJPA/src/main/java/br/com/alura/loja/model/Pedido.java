package br.com.alura.loja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private LocalDate data = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private br.com.alura.loja.model.Cliente cliente;

    public List<ItemPedido> getItens() {
        return itens;
    }

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(br.com.alura.loja.model.Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item);
        this.valorTotal = this.valorTotal.add(item.getValor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public br.com.alura.loja.model.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(br.com.alura.loja.model.Cliente cliente) {
        this.cliente = cliente;
    }

}
