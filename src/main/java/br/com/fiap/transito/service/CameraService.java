package br.com.fiap.transito.service;


import br.com.fiap.transito.model.Camera;
import br.com.fiap.transito.model.Veiculo;
import br.com.fiap.transito.repository.CameraRepository;
import br.com.fiap.transito.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {


    @Autowired
    private  CameraRepository cameraRepository;

    public  Camera inserirNovasPassagens(Camera camera){
        return cameraRepository.save(camera);
    }

    public List<Camera> listarTodasCameras(){
        return cameraRepository.findAll();
    }


        public void excluirPassagemVeiculo(Long idCamera){
        Optional<Camera> cameraOp = cameraRepository.findById(idCamera);
        if (cameraOp.isPresent()){
            cameraRepository.delete(cameraOp.get());
            } else {
               throw new RuntimeException("Registro não existe.");
            }
        }
    public Camera atualizarPassagemVeiculo(Camera camera) {
        Optional<Camera> cameraOptional = cameraRepository.findByIdCamera(camera.getIdCamera());

        if (cameraOptional.isPresent()) {
            cameraRepository.save(camera);
        } else {
            throw new RuntimeException("Registro não encontrado!");
        }

        return camera;
    }



}
