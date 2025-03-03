package br.com.fiap.transito.controller;


import br.com.fiap.transito.model.Camera;
import br.com.fiap.transito.service.CameraService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @PostMapping("/camera")
    @ResponseStatus(HttpStatus.CREATED)
    public Camera inserirNovasPassagens(@RequestBody Camera camera){
        return cameraService.inserirNovasPassagens(camera);
    }


    @GetMapping("/camera")
    @ResponseStatus(HttpStatus.OK)
    public List<Camera> listarTodasCameras (){
        return cameraService.listarTodasCameras();
    }


    @DeleteMapping("/camera/{idCamera}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPassagemVeiculo(@PathVariable Long idCamera){
        cameraService.excluirPassagemVeiculo(idCamera);
    }

    @PutMapping("/camera/atualizar-passagem-veiculo")
    public Camera atualizarPassagemVeiculo(@RequestBody Camera camera){
        return cameraService.atualizarPassagemVeiculo(camera);
    }


}
