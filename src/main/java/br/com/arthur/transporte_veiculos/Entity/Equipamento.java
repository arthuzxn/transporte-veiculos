package br.com.arthur.transporte_veiculos.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_EQUIPAMENTO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placaCavalo;
    private String placaCarreta;
    private String modeloCavalo;
    private String modeloCarreta;
    @ManyToOne
    @JoinColumn(name="transportadora_id")
    private Transportadora transportadora;
}
