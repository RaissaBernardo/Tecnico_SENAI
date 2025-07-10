package com.avaliacao.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estoque")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_material")
    private String tipoMaterial;

    private String descricao;

    @Column(name = "id_produto")
    private Long idProduto;

    private Integer quantidadeAtual;
}
