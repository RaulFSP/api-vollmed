CREATE TABLE enderecos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf varchar(2) not null,
    cidade varchar(100) not null
);
CREATE TABLE medicos (
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade ENUM('CARDIOLOGIA', 'ORTOPEDIA', 'GINECOLOGIA', 'DERMATOLOGIA'),
    endereco_id BIGINT NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    
    CONSTRAINT fk_medicos_endereco FOREIGN KEY (endereco_id) REFERENCES enderecos(id) ON UPDATE CASCADE ON DELETE CASCADE
);

