package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Encapsulando o código de listar as empresas
public class MostrarEmpresa implements Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Mostrar Empresa");

        String paramId = req.getParameter("id");
        // Parsing
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        Empresa empresa = banco.buscarEmpresaPorId(id);

        System.out.println(empresa.getNome());

        req.setAttribute("empresa", empresa);

        return "forward:formAlteraEmpresa.jsp";
    }
}
