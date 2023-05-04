package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Encapsulando o código de listar as empresas
public class AlterarEmpresa {
    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        System.out.println("ID Alterado: " + id);

        Banco banco = new Banco();
        Empresa empresa = banco.buscarEmpresaPorId(id);

        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        resp.sendRedirect("entrada?acao=ListarEmpresas");
    }
}
