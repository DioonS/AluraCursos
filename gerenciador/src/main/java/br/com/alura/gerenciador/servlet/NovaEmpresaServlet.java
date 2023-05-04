package br.com.alura.gerenciador.servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "novaEmpresa", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = request.getParameter("nome");
        String dataEmpresa = request.getParameter("data");

        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(dataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        //PrintWriter out = response.getWriter();

        request.setAttribute("empresa", empresa.getNome());

        response.sendRedirect("listaEmpresas");

        /*// Chamar o JSP para apresentar o HTML
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);*/
    }
}