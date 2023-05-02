package br.com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listaEmpresas", value = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        //PrintWriter out = resp.getWriter();

        req.setAttribute("empresas", lista);

        RequestDispatcher rd = req.getRequestDispatcher("/listarEmpresas.jsp");
        rd.forward(req, resp);
    }
}
