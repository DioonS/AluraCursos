package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.controller.Acao;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ControladorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println("ControladorFilter");

        // Casting
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.alura.gerenciador.controller." + paramAcao;

        String nome;
        // Carrega a classe com o nome requisitado
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] tipoEndereco = nome.split(":");

        if (tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(req, resp);
        } else {
            // Redirecionando após a remoção da Empresa
            response.sendRedirect(tipoEndereco[1]);
        }
    }
}
