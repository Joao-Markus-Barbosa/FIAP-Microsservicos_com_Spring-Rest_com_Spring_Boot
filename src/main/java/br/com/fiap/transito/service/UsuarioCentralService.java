package br.com.fiap.transito.service;

import br.com.fiap.transito.model.Central;
import br.com.fiap.transito.repository.CentralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCentralService  {


    @Autowired
    private CentralRepository centralRepository;

    public Central save(Central central){
    if (central.getSenhaAcesso() == null || central.getSenhaAcesso().isEmpty()) {
        throw new IllegalArgumentException("123");
    }
    String encodedPassword = new BCryptPasswordEncoder().encode(central.getSenhaAcesso());
    central.setSenhaAcesso(encodedPassword);
    return centralRepository.save(central);
}



}
