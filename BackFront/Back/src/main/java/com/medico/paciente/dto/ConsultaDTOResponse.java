package com.medico.paciente.dto;

import com.medico.paciente.entity.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTOResponse {
    private Long id;
    private LocalDateTime dataHora;
    private String observacoes;
    private MedicoDTO medico;
    private PacienteDTO pacienteDTO;

    public static ConsultaDTOResponse fromEntity(Consulta consulta) {
        return new ConsultaDTOResponse(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getObservacoes(),
                consulta.getMedico().getId(),
                consulta.getMedico().getNome(),
                consulta.getPaciente().getCpf(), // <- Aqui pega o CPF
                consulta.getPaciente().getNome()
        );
    }
}
