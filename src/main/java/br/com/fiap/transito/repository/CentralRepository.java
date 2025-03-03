package br.com.fiap.transito.repository;

import br.com.fiap.transito.model.Central;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface CentralRepository extends JpaRepository<Central, Long> {


    UserDetails findByUserNameCentral(String userNameCentral);

}
