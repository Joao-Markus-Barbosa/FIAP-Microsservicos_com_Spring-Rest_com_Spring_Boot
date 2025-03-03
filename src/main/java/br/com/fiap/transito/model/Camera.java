package br.com.fiap.transito.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "camera")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Camera {


    public Long getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(Long idCamera) {
        this.idCamera = idCamera;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CAMERAS"
    )
    @SequenceGenerator(
            name = "SEQ_CAMERAS",
            sequenceName = "SEQ_CAMERAS",
            allocationSize = 1
    )
    @Column(name = "ID_CAMERA")
    private Long idCamera;



    @Column(name = "QT_PASSAGEM_VEICULO")
    private Integer qtPassagemVeiculo;

    @Column(name = "DATA_PASSAGEM_VEICULO")
    private LocalDate dataPassagemVeiculo;

    @Column(name = "NM_AVENIDA")
    private String nmAvenida;


}
