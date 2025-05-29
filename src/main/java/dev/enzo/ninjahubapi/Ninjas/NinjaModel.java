package dev.enzo.ninjahubapi.Ninjas;
import dev.enzo.ninjahubapi.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Annotation entity que transforma a java class em um entidade do banco de dados
@Table(name = "tb_ninjaRegister") // Annotation Tabela que vai tem as colunas de id, nome, email, idade.
//(name = ) 'e o nome da tabela

public class NinjaModel {
    @Id// annotation Id preenche o id e incrementa automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Long id;
      private String nome;
      private String email;
      private int idade;

      //@ManyToOne um ninja tem uma unica missao
      @ManyToOne()
      // joinColumn vai criar uma coluna chamada missoes_id na tabela NinjaRegister
      @JoinColumn(name = "missoes_id")
      private MissoesModel missoes;

}
