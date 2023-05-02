package br.com.alura.gerenciador;

import java.io.*;

import br.com.alura.gerenciador.servlet.Banco;
import br.com.alura.gerenciador.servlet.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "novaEmpresa", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.setContentType("text/html");

        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = request.getParameter("nome");
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        PrintWriter out = response.getWriter();

        // Chamar o JSP para apresentar o HTML
        RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);
    }
}