package dev.enzo.ninjahubapi.Ninjas;
import dev.enzo.ninjahubapi.Missoes.MissoesModel;
import jakarta.persistence.*;


import java.util.List;

@Entity // Annotation entity que transforma a java class em um entidade do banco de dados
@Table(name = "tb_ninjaRegister") // Annotation Tabela que vai tem as colunas de id, nome, email, idade.
//(name = ) 'e o nome da tabela

public class NinjaModel {
    @Id// annotation Id preenche o id e incrementa automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Long id;
      private String nome;
    // annotation que deixa essa coluna da tabela unica, ou seja
    //dois usuarios nao podem ter o memso email
      @Column(unique = true)
      private String email;
      private int idade;

      //@ManyToOne um ninja tem uma unica missao
      @ManyToOne()
      // joinColumn vai criar uma coluna chamada missoes_id na tabela NinjaRegister
      @JoinColumn(name = "missoes_id")
      private MissoesModel missoes;

}
