package com.medico.paciente.repository;

import com.medico.paciente.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT c FROM Consulta c JOIN FETCH c.medico JOIN FETCH c.paciente")
    List<Consulta> findAllComMedicoEPaciente();

    List<Consulta> findByPacienteCpf(String cpf);

}
