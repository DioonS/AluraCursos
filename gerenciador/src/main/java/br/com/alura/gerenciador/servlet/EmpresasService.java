package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*import com.google.code.gson;*/

import java.io.IOException;
import java.util.List;

@WebServlet(name = "empresas", value = "/empresas")
public class EmpresasService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Empresa> empresas = new Banco().getEmpresas();

        String valor = req.getHeader("Accept");

        System.out.println(valor);

        if (valor.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            String xml = xStream.toXML(empresas);

            resp.setContentType("application/xml");
            resp.getWriter().print(xml);
        } else if (valor.endsWith("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(empresas);

            resp.setContentType("application/json");
            resp.getWriter().print(json);
        } else {
            resp.setContentType("application/json");
            resp.getWriter().print("{'message':'no content'}");
        }
    }
}
