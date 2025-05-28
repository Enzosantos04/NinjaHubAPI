package dev.enzo.ninjahubapi;


import jakarta.persistence.*;

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

    public NinjaModel(int idade, String email, String nome) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
    }

    public NinjaModel(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
