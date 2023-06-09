package br.com.alura.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

public class MonitoriamentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println("MonitoramentoFilter");

        long antes = System.currentTimeMillis();

        String acao = req.getParameter("acao");

        // Executar a ação
        chain.doFilter(req, resp);

        long depois = System.currentTimeMillis();

        System.out.println("Tempo de execução da ação: " + acao + " -> " + (depois - antes));
        System.out.println("Tempo antes: " + antes + " - Tempo depois: " + depois);
    }

    @Override
    public void destroy() {
    }
}
