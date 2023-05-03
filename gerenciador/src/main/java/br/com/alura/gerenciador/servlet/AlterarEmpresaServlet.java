package br.com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "alterarEmpresa", value = "/alterarEmpresa")
public class AlterarEmpresaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Alterar Empresa");

        String nomeEmpresa = req.getParameter("nome");
        String dataEmpresa = req.getParameter("data");
        String paramIdEmpresa = req.getParameter("id");
        Integer id = Integer.valueOf(paramIdEmpresa);

        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(dataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        System.out.println(id);

        Banco banco = new Banco();
        Empresa empresa = banco.buscarEmpresaPorId(id);

        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        resp.sendRedirect("listaEmpresas");
    }
}
