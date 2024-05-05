package br.edu.utfpr.pedido.dto;

import br.edu.utfpr.pedido.model.ItemPedido;
import br.edu.utfpr.pedido.model.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoDto {
    private Long id;
    private LocalDateTime datahora;
    private Status status;
    private List<ItemPedidoDto> itens = new ArrayList<>();
}
