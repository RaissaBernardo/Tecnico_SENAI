package com.medico.paciente.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    private String cpf;

    private String nome;

    private String telefone;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;
}
