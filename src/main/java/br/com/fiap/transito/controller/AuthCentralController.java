package br.com.fiap.transito.controller;


import br.com.fiap.transito.model.Central;
import br.com.fiap.transito.security.service.TokenService;
import br.com.fiap.transito.service.UsuarioCentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/central")
public class AuthCentralController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioCentralService usuarioCentralService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Central central){

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        central.getUsername(),
                        central.getSenhaAcesso());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        String token = tokenService.createToken((Central) authentication.getPrincipal());

        return  ResponseEntity.ok(token);

    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public Central registrarUsuarioCentral(@RequestBody Central central){
        Central newCentral = usuarioCentralService.save(central);
        return newCentral;
    }



}
