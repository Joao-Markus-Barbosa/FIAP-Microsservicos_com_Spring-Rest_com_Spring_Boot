package br.com.fiap.transito.repository;

import br.com.fiap.transito.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


    public Optional<Veiculo> findByIdVeiculo(Long idVeiculo);

}
