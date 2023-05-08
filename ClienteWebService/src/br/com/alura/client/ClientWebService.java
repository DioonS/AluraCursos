package br.com.alura.client;

import org.apache.http.client.fluent.Request;


public class ClientWebService {
    public static void main(String[] args) throws Exception {
        String conteudo =  Request
                .Post("http://localhost:8080/gerenciador/empresas")
                .addHeader("Accept", "application/xml")
                .execute()
                .returnContent()
                .asString();

        System.out.println(conteudo);
    }
}
