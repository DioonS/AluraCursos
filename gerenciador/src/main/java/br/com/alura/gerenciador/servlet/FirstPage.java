package br.com.alura.gerenciador.servlet;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hello", value = "/hello")
public class FirstPage extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Hello World!");
        out.println("Parabens voce escreveu o primeiro Servlet");
        out.println("<body>");
        out.println("<html>");

        System.out.println("Carregado");
    }
}
