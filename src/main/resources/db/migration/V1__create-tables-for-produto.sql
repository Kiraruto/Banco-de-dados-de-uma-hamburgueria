CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE carne (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    origin VARCHAR(255),
    weight INTEGER NOT NULL,
    harvest_date TIMESTAMP NOT NULL,
    price DOUBLE NOT NULL,
    validity TIMESTAMP NOT NULL,
    fat_percentage DOUBLE NOT NULL,
    produto_id BIGINT ,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE paes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type_of_bread VARCHAR(255) NOT NULL,
    weight INTEGER NOT NULL,
    manufacturing_date TIMESTAMP NOT NULL,
    price DOUBLE NOT NULL,
    validity TIMESTAMP NOT NULL,
    produto_id BIGINT ,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE verduras_frutas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    origin VARCHAR(255),
    weight INTEGER NOT NULL,
    harvest_date TIMESTAMP NOT NULL,
    price DOUBLE NOT NULL,
    validity TIMESTAMP NOT NULL,
    produto_id BIGINT,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
