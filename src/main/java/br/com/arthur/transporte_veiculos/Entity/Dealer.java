package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_DEALER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dealer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoDealer;
    private String nome;
    @OneToOne
    @JoinColumn(name = "endereco_id", unique = true)
    private Endereco endereco;
    @ManyToMany(mappedBy = "dealers")
    private List<Viagem>viagens;
}
