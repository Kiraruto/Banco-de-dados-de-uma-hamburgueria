CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    pagamento_id BIGINT,
    status BOOLEAN NOT NULL,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE pagamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    payment_method VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);

CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user BIGINT NOT NULL,
    street VARCHAR(255) NOT NULL,
    number varchar(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    zip_code INTEGER NOT NULL,
    state varchar(255) NOT NULL
);

CREATE TABLE item_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produto_id BIGINT,
    pedido_id BIGINT,
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
