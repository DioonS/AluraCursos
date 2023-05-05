package br.com.alura.gerenciador.controller;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println("Logando o usuário: " + login);

        Banco banco = new Banco();
        Users users = banco.existeUsuario(login, senha);

        if (users != null) {
            System.out.println("Usuario Logado");

            // Armazenando Cookies
            HttpSession sessao = req.getSession();

            sessao.setAttribute("usuarioLogado", users);

            return "redirect:entrada?acao=ListarEmpresas";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }
    }
}
