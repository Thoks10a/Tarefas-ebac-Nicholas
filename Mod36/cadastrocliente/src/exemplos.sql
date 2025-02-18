    create table tb_cliente (
	id bigint,
	nome varchar(50) not null,
	cpf bigint not null,
	tel bigint not null,
	endereco varchar(50) not null,
	numero bigint not null,
	cidade varchar(50) not null,
	estado varchar(50) not null,
	-- novo campo adcionado
	cep bigint not null,
	constraint pk_id_cliente primary key(id)
);

-- produto é uma lista de produtos
create table tb_produto(
	id bigint,
	codigo varchar(10) not null,
	nome varchar(50) not null,
	descricao varchar(100) not null,
	valor numeric(10,2) not null,
	-- novo campo adcionado
	tipo varchar(50) not null,
	constraint pk_id_produto primary key(id)
);


create table tb_estoque(
	id bigint,
	codigo varchar(10) not null,
	nome varchar(50) not null,
	id_produto_fk bigint not null,
	constraint pk_id_estoque primary key(id),
	constraint fk_id_estoque_produto foreign key(id_produto_fk) references tb_produto(id)
);



-- para qual cliente fez a venda do produto
create table tb_venda(
	id bigint,
	codigo varchar(10) not null,
	id_cliente_fk bigint not null,
	id_estoque_fk bigint not null,
	valor_total numeric(10,2) not null,
	data_venda TIMESTAMPTZ not null,
	status_venda varchar(50) not null,
	constraint pk_id_venda primary key(id),
	constraint fk_id_cliente_venda foreign key(id_cliente_fk) references tb_cliente(id)
	-- nova coluna
	constraint fk_id_venda_estoque foreign key(id_estoque_fk) references tb_estoque(id)
);


ALTER TABLE tb_venda ADD CONSTRAINT fk_id_venda_estoque 
FOREIGN KEY(id_estoque_fk) REFERENCES tb_estoque(id)

create table tb_produto_quantidade(
	id bigint,
	id_produto_fk bigint not null,
	id_venda_fk bigint not null,
	quantidade int not null,
	valor_total numeric(10,2) not null,
	constraint pk_id_prod_venda primary key(id),
	constraint fk_id_prod_venda foreign key(id_produto_fk) references tb_produto(id),
	constraint fk_id_prod_venda_venda foreign key(id_venda_fk) references tb_venda(id)
);

create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;

create sequence sq_produto
start 1
increment 1
owned by tb_produto.id;

create sequence sq_estoque
start 1
increment 1
owned by tb_produto.id;

create sequence sq_venda
start 1
increment 1
owned by tb_venda.id;

create sequence sq_produto_quantidade
start 1
increment 1
owned by tb_produto_quantidade.id;

ALTER TABLE TB_CLIENTE
ADD CONSTRAINT UK_CPF_CLIENTE UNIQUE (CPF);

ALTER TABLE TB_PRODUTO
ADD CONSTRAINT UK_CODIGO_PRODUTO UNIQUE (CODIGO);

--novo
ALTER TABLE TB_ESTOQUE
ADD CONSTRAINT UK_CODIGO_ESTOQUE UNIQUE (CODIGO);

ALTER TABLE TB_VENDA
ADD CONSTRAINT UK_CODIGO_VENDA UNIQUE (CODIGO);

--novo
ALTER TABLE TB_VENDA
ADD CONSTRAINT UK_CODIGO_VENDA UNIQUE (CODIGO);

--novo
SELECT V.ID AS ID_VENDA, V.CODIGO, V.ID_CLIENTE_FK, V.VALOR_TOTAL, V.DATA_VENDA, V.STATUS_VENDA,
C.ID AS ID_CLIENTE, C.NOME, C.CPF, C.TEL, C.ENDERECO, C.NUMERO, C.CIDADE, C.ESTADO,
P.ID AS ID_PROD_QTD, P.QUANTIDADE, P.VALOR_TOTAL AS PROD_QTD_VALOR_TOTAL,
E.ID as ID_ESTOQUE, E.NOME
FROM TB_VENDA V 
INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE_FK = C.ID
INNER JOIN TB_PRODUTO_QUANTIDADE P ON P.ID_VENDA_FK = V.ID
INNER JOIN TB_ESTOQUE E ON E.ID_PRODUTO_FK = V.ID
WHERE V.CODIGO = 'A1';


SELECT PQ.ID, PQ.QUANTIDADE, PQ.VALOR_TOTAL,
P.ID AS ID_PRODUTO, P.CODIGO, P.NOME, P.DESCRICAO, P.VALOR
FROM TB_PRODUTO_QUANTIDADE PQ
INNER JOIN TB_PRODUTO P ON P.ID = PQ.ID_PRODUTO_FK;