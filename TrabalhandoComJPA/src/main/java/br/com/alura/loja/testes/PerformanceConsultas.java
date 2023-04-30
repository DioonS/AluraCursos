package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.*;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PerformanceConsultas {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();

        // Exemplo de query planejada
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = pedidoDao.buscarPedidoComCliente(1l);

        em.close();

        // Exemplo de query planejada:
        System.out.println(pedido.getCliente().getNome());
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Mi Lite 11", new BigDecimal("1980"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("5600"), videogames);
        Produto macbook = new Produto("MacBook", "Macbook Pro Retina", new BigDecimal("14000"), informatica);

        Cliente cliente = new Cliente("Diego Silva", "21324321320");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);

        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }

}
