package br.com.fiap.transito.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Veiculo {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_VEICULOS"
    )
    @SequenceGenerator(
            name = "SEQ_VEICULOS",
            sequenceName = "SEQ_VEICULOS",
            allocationSize = 1
    )
    @Column(name = "ID_VEICULO")
    private Long idVeiculo;


    @Column(name = "MODELO_VEICULO")
    private String modeloVeiculo;

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}
