package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.controller.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "entrada", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAcao = req.getParameter("acao");

        HttpSession sessao = req.getSession();

        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (acaoProtegida && usuarioNaoEstaLogado) {
            resp.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        String nomeDaClasse = "br.com.alura.gerenciador.controller." + paramAcao;

        String nome;
        // Carrega a classe com o nome requisitado
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] tipoEndereco = nome.split(":");

        if (tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(req, resp);
        } else {
            // Redirecionando após a remoção da Empresa
            resp.sendRedirect(tipoEndereco[1]);
        }
    }
}