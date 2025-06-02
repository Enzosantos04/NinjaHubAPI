package dev.enzo.ninjahubapi.Missoes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.enzo.ninjahubapi.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor // construtor sem argumentos pela annotation do lombok
@AllArgsConstructor //construtor com todos os argumentos pela annotation do lombok
@Data // essa annotation cria todos os getters e setters
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private String dificuldade;

    //OneToMany uma missao tem varios Ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore // essa annotation evita o loop de serializacao
    private List<NinjaModel> ninja;

}
