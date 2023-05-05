package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Encapsulando o código de listar as empresas
public class FormNovaEmpresa {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return "forward:formNovaEmpresa.jsp";
    }
}
