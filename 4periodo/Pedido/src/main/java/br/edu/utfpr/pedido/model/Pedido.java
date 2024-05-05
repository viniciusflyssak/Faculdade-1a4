package br.edu.utfpr.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
    private LocalDateTime datahora;

//    @NotNull
    @Enumerated
    private Status status;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();
}
