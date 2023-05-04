package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acoes.*;
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

        if (paramAcao.equals("ListarEmpresas")) {

            ListarEmpresas acao = new ListarEmpresas();
            acao.executa(req, resp);

        } else if (paramAcao.equals("RemoverEmpresa")) {

            RemoveEmpresa acao = new RemoveEmpresa();
            acao.executa(req, resp);

        } else if (paramAcao.equals("MostrarEmpresa")) {

            MostrarEmpresa acao = new MostrarEmpresa();
            acao.executa(req, resp);
        } else if (paramAcao.equals("AlterarEmpresa")) {

            AlterarEmpresa acao = new AlterarEmpresa();
            acao.executa(req, resp);
        } else if (paramAcao.equals("NovaEmpresa")) {

            NovaEmpresa acao = new NovaEmpresa();
            acao.executa(req, resp);
        }
    }
}