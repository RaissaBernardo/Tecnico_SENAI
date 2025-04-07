package com.medico.paciente.dto;

import com.medico.paciente.entity.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String observacoes;
    private Long medicoId;
    private String nomeMedico;
    private String pacienteCpf; // <- Aqui muda de pacienteId para pacienteCpf
    private String nomePaciente;

    public static ConsultaDTO fromEntity(Consulta consulta) {
        return new ConsultaDTO(
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
