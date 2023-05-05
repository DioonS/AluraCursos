package br.com.alura.gerenciador.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Encapsulando o código de listar as empresas
public class FormNovaEmpresa implements Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return "forward:formNovaEmpresa.jsp";
    }
}
