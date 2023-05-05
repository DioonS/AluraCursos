package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acoes.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "entrada", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAcao = req.getParameter("acao");

        String nome = null;

        if (paramAcao.equals("ListarEmpresas")) {

            ListarEmpresas acao = new ListarEmpresas();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("RemoverEmpresa")) {

            RemoveEmpresa acao = new RemoveEmpresa();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("MostrarEmpresa")) {

            MostrarEmpresa acao = new MostrarEmpresa();
            nome = acao.executa(req, resp);
        } else if (paramAcao.equals("AlterarEmpresa")) {

            AlterarEmpresa acao = new AlterarEmpresa();
            nome = acao.executa(req, resp);
        } else if (paramAcao.equals("NovaEmpresa")) {

            NovaEmpresa acao = new NovaEmpresa();
            nome = acao.executa(req, resp);
        } else if (paramAcao.equals("FormNovaEmpresa")) {

            FormNovaEmpresa acao = new FormNovaEmpresa();
            nome = acao.executa(req, resp);
        }

        // Split devolve um Array, separado por :
        String[] tipoEndereco = nome.split(":");

        if (tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(req, resp);
        } else {
            // Redirecionando após a remoção da Empresa
            resp.sendRedirect("WEB-INF/view/" + tipoEndereco[1]);
        }
    }
}