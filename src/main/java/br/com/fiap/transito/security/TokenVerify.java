package br.com.fiap.transito.security;

import br.com.fiap.transito.model.Central;
import br.com.fiap.transito.repository.CentralRepository;
import br.com.fiap.transito.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenVerify extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CentralRepository centralRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


            String authorizationHeader = request.getHeader("Authorization");
            String token ="";

            if (authorizationHeader == null){
                token = null;
            }else {
                token = authorizationHeader.replace("Bearer", "").trim();
                String login = tokenService.tokenValidate(token);
                UserDetails usuario = centralRepository.findByUserNameCentral(login);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                usuario,
                                null,
                                usuario.getAuthorities()
                        );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            filterChain.doFilter(request, response);
        }
        
}
