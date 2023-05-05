package br.com.alura.gerenciador.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginForm implements Acao {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "forward:formLogin.jsp";
    }
}
