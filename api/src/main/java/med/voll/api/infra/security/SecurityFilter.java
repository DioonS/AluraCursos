package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // Utilizado para que o Spring carregue uma classe/componente genérico
public class SecurityFilter extends OncePerRequestFilter {

    // A classe doFilterInternal garante que o filtro será executado uma unica vez por request
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(req);

        System.out.println(tokenJWT);

        chain.doFilter(req, resp); // Chamar o proximo filtro !
    }

    // Devolve a String do Token
    private String recuperarToken(HttpServletRequest req) {
        var authorizationHeader = req.getHeader("Authorization");
        if (authorizationHeader == null) {
            throw new RuntimeException("Token JWT não informado no cabeçalho Authorization!");
        }

        return authorizationHeader.replace("Bearer ", ""); // Replace retira o prefixo do token
    }
}
