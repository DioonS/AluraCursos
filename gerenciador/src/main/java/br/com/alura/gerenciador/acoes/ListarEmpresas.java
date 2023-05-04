package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// Encapsulando o código de listar as empresas
public class ListarEmpresas {
    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);

        RequestDispatcher rd = req.getRequestDispatcher("/listarEmpresas.jsp");
        rd.forward(req, resp);
    }
}
