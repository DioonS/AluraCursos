package br.com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mostrarEmpresa", value = "/mostrarEmpresa")
public class MostrarEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        // Parsing
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        Empresa empresa = banco.buscarEmpresaPorId(id);

        System.out.println(empresa.getNome());

        req.setAttribute("empresa", empresa);
        RequestDispatcher rd = req.getRequestDispatcher("formAlteraEmpresa.jsp");
        rd.forward(req, resp);

    }
}
