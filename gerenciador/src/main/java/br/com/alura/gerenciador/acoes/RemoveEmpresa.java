package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.model.Banco;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Encapsulando o código de listar as empresas
public class RemoveEmpresa {
    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Removendo empresa");

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        // Redirecionando após a remoção da Empresa
        resp.sendRedirect("entrada?acao=ListarEmpresas");
    }
}
