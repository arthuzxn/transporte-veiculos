package Entity;

import jakarta.persistence.*;

import java.util.List;

public class Filial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoFilial;
    @OneToOne
    @JoinColumn(name = "endereco_id", unique = true)
    private Endereco endereco;
    @OneToMany(mappedBy = "filial")
    private List<Viagem> viagens;



}
