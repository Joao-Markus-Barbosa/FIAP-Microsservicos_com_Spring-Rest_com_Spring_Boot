package br.com.fiap.transito.controller;


import br.com.fiap.transito.model.Camera;
import br.com.fiap.transito.model.Veiculo;
import br.com.fiap.transito.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/veiculo")
    @ResponseStatus( HttpStatus.CREATED)
    public Veiculo inserirModeloVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.inserirModeloVeiculo(veiculo);
    }


    @GetMapping("/veiculo")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> saberTodosOsModelosVeiculos(){
        return veiculoService.saberTodosOsModelosVeiculos();
    }

    @DeleteMapping("/veiculo/{idVeiculo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirRegistroVeiculo(@PathVariable Long idVeiculo){
        veiculoService.excluirRegistroVeiculo(idVeiculo);

    }

    @PutMapping("/camera/atualizar-registro-veiculo")
    public Veiculo atualizarRegistroVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.atualizarRegistroVeiculo(veiculo);
    }


}
