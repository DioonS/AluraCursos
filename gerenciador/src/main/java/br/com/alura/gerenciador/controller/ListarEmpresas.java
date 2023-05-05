package br.com.alura.gerenciador.controller;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

// Encapsulando o código de listar as empresas
public class ListarEmpresas implements Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        System.out.println("Listar empresas");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);



        return "forward:listarEmpresas.jsp";
    }
}
