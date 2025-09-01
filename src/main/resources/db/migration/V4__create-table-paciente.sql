CREATE TABLE pacientes (
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    endereco_id BIGINT NOT NULL,
    telefone varchar(20) not null,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT fk_pacientes_endereco FOREIGN KEY (endereco_id) REFERENCES enderecos(id) ON UPDATE CASCADE ON DELETE CASCADE
);