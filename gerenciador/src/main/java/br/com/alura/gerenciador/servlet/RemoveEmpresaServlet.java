package br.com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removeEmpresa", value = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        resp.sendRedirect("listaEmpresas");
    }
}
