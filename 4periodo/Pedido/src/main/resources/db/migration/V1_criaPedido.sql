CREATE TABLE pedido(
    id serial PRIMARY KEY,
    datahora datetime NOT NULL,
    status varchar(255) not null
);