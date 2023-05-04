package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Simulando um banco de dados
public class Banco {

    private static List<Empresa> lista = new ArrayList<>();

    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        empresa.setNome("Alura");
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Google");
        Empresa empresa3 = new Empresa();
        empresa3.setId(chaveSequencial++);
        empresa3.setNome("Tesla");
        Empresa empresa4 = new Empresa();
        empresa4.setId(chaveSequencial++);
        empresa4.setNome("N2 Acessoria");
        lista.add(empresa);
        lista.add(empresa2);
        lista.add(empresa3);
        lista.add(empresa4);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        lista.add(empresa);
        //System.out.println("Cadastrando empresa no banco de dados");
    }

    public List<Empresa> getEmpresas() {
        return Banco.lista;
    }

    public void removeEmpresa(Integer id) {

        Iterator<Empresa> it = lista.iterator();

        while(it.hasNext()) {
            Empresa emp = it.next();
            if (emp.getId() == id) {
                it.remove();
            }
        }

        // Não pode usar laço para remover um item de uma mesma lista
        /*for (Empresa empresa : lista) {
            if (empresa.getId() == id) {
                lista.remove(empresa);
            }
        }*/
    }

    public Empresa buscarEmpresaPorId(Integer id) {
        for (Empresa empresa : lista) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }
}
