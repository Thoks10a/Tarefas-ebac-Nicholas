CREATE SEQUENCE sequence_usuario START WITH 1 INCREMENT BY 50;

CREATE TABLE usuario (
  id BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   data_cadastro date NOT NULL,
   CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE SEQUENCE sequence_categoria_meme START WITH 1 INCREMENT BY 50;

CREATE TABLE categoria_meme (
  id BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   descricao VARCHAR(255) NOT NULL,
   data_cadastro date NOT NULL,
   usuario_id BIGINT,
   CONSTRAINT pk_categoriameme PRIMARY KEY (id)
);

ALTER TABLE categoria_meme ADD CONSTRAINT FK_CATEGORIAMEME_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuario (id);

CREATE SEQUENCE sequence_meme START WITH 1 INCREMENT BY 50;

CREATE TABLE meme (
  id BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   descricao VARCHAR(255) NOT NULL,
   data_cadastro date NOT NULL,
   categoria_meme_id BIGINT,
   usuario_id BIGINT,
   CONSTRAINT pk_meme PRIMARY KEY (id)
);

ALTER TABLE meme ADD CONSTRAINT FK_MEME_ON_CATEGORIA_MEME FOREIGN KEY (categoria_meme_id) REFERENCES categoria_meme (id);

ALTER TABLE meme ADD CONSTRAINT FK_MEME_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuario (id);

INSERT INTO usuario (id, nome, email, data_cadastro) VALUES (1, 'João da Silva', 'joao.silva@example.com', '2021-01-01');
INSERT INTO categoria_meme (id, nome, descricao, data_cadastro, usuario_id) VALUES (1, 'Categoria 1', 'Descrição da Categoria 1', '2021-01-01', 1);
INSERT INTO meme (id, nome, descricao, data_cadastro, categoria_meme_id, usuario_id) VALUES (1, 'Meme 1', 'Descrição do Meme 1', '2021-01-01', 1, 1);
INSERT INTO categoria_meme (id, nome, descricao, data_cadastro, usuario_id) VALUES (2, 'Categoria 2', 'Descrição da Categoria 2', '2021-01-02', 1);
INSERT INTO categoria_meme (id, nome, descricao, data_cadastro, usuario_id) VALUES (3, 'Categoria 3', 'Descrição da Categoria 3', '2021-01-03', 1);
