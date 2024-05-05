package br.edu.utfpr.pedido.dto;

import lombok.Data;
@Data
public class ItemPedidoDto {
    private Long id;
    private String descricao;
    private Integer quantidade;
}
