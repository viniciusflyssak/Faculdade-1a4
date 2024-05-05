CREATE TABLE item_pedido(
    id serial PRIMARY KEY,
    quantidade int NOT NULL,
    descricao varchar(255) not null,
    pedido_id bigint NOT NULL,
    CONSTRAINT fk_pedido
                   foreign key (pedido_id)
                   references pedido(id)
);