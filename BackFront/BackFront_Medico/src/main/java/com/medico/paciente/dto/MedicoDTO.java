package com.medico.paciente.dto;

import lombok.Data;

@Data
public class MedicoDTO {
    private Long id;
    private String nome;
    private String especialidade;
    private String crm;
    // sem a lista de consultas
}
