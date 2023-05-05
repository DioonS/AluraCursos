package br.com.alura.gerenciador.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
