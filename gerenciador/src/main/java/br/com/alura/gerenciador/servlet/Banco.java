package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

// Simulando um banco de dados
public class Banco {

    private static List<Empresa> lista = new ArrayList<>();

    static {
        Empresa empresa = new Empresa();
        empresa.setNome("Alura");
        Empresa empresa2 = new Empresa();
        empresa2.setNome("Google");
        Empresa empresa3 = new Empresa();
        empresa3.setNome("Tesla");
        Empresa empresa4 = new Empresa();
        empresa4.setNome("N2 Acessoria");
        lista.add(empresa);
        lista.add(empresa2);
        lista.add(empresa3);
        lista.add(empresa4);
    }

    public void adiciona(Empresa empresa) {
        lista.add(empresa);
        //System.out.println("Cadastrando empresa no banco de dados");
    }

    public List<Empresa> getEmpresas() {
        return Banco.lista;
    }
}
