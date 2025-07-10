package com.avaliacao.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedi_prod")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PediProd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_produto")
    private Long idProduto;

    private Integer quantidade;
}
