package br.com.alura.gerenciador.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println("Logando o usuário: " + login);

        return "redirect:entrada?acao=ListarEmpresas";
    }
}
