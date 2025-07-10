package com.raissa.avalia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
