package br.com.fiap.transito.service;

import br.com.fiap.transito.model.Veiculo;
import br.com.fiap.transito.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VeiculoService {


    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo inserirModeloVeiculo (Veiculo veiculo) {
        return  veiculoRepository.save(veiculo);
    }



    public List<Veiculo> saberTodosOsModelosVeiculos() {
        return veiculoRepository.findAll();
    }


    public void excluirRegistroVeiculo(Long idVeiculo){

       Optional<Veiculo> veiculoOp = veiculoRepository.findById(idVeiculo);
       if (veiculoOp.isPresent()){
           veiculoRepository.delete(veiculoOp.get());
       } else {
           throw new RuntimeException(" Modelo de veículo não existe.");
       }
    }

    public Veiculo atualizarRegistroVeiculo(Veiculo veiculo) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findByIdVeiculo(veiculo.getIdVeiculo());

        if (veiculoOptional.isPresent()) {
            veiculoRepository.save(veiculo);
        } else {
            throw new RuntimeException("Registro não encontrado!");
        }


        return veiculo;
    }




}
