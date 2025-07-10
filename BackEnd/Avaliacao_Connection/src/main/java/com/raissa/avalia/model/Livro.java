package com.raissa.avalia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private Long idLivro;
    private String nome;
    private String autor;
    private String genero;
}
