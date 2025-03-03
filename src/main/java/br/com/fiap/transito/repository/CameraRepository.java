package br.com.fiap.transito.repository;

import br.com.fiap.transito.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CameraRepository extends JpaRepository<Camera, Long> {

    public Optional<Camera> findByIdCamera(Long idCamera);



}
