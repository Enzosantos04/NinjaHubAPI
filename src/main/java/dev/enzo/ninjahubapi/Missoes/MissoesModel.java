package dev.enzo.ninjahubapi.Missoes;


import dev.enzo.ninjahubapi.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private String dificuldade;

    //OneToMany uma missao tem varios Ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}
