package br.com.alura.gerenciador;

import java.io.*;

import br.com.alura.gerenciador.servlet.Banco;
import br.com.alura.gerenciador.servlet.Empresa;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "novaEmpresa", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    /*private String message;

    public void init() {
        message = "Hello World!";
    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setContentType("text/html");

        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = request.getParameter("nome");
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        PrintWriter out = response.getWriter();
    }

/*    public void destroy() {
    }*/
}