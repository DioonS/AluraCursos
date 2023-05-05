package br.com.alura.gerenciador.controller;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout implements Acao{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sessao = req.getSession();

        // Primeira forma de fazer:
        //sessao.removeAttribute("usuarioLogado");

        // Melhor forma de fazer
        sessao.invalidate();

        return "redirect:entrada?acao=LoginForm";
    }
}
