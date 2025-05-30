package dev.enzo.ninjahubapi.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long>{
    //abstracao para lidar com banco de dados, abstracao deixa o entendimento mais facil


}
