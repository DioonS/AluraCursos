package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acoes.ListarEmpresas;
import br.com.alura.gerenciador.acoes.MostrarEmpresa;
import br.com.alura.gerenciador.acoes.RemoveEmpresa;
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
            System.out.println("Listando Empresas");

            ListarEmpresas acao = new ListarEmpresas();
            acao.executa(req, resp);

        } else if (paramAcao.equals("RemoverEmpresa")) {
            System.out.println("Removendo Empresa");

            RemoveEmpresa acao = new RemoveEmpresa();
            acao.executa(req, resp);

        } else if (paramAcao.equals("MostrarEmpresas")) {

            MostrarEmpresa acao = new MostrarEmpresa();
            acao.executa(req, resp);
        }
    }
}