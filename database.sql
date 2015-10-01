-- Tabela equipe
-- Mais tarde serão populadas com os usuários

CREATE TABLE equipe(
    codigo int not null AUTO_INCREMENT,
	nome VARCHAR(45) not null,
	primary key(codigo),
	unique(nome)
);

INSERT INTO equipe(nome) VALUES ('USUÁRIOS'); -- USUÁRIOS DEVEM SER OS PRIMEIROS!
INSERT INTO equipe(nome) VALUES ('Suporte'); -- EQUIPE DO ADMINISTRADOR DO SISTEMA
INSERT INTO equipe(nome) VALUES ('Service Desk'); -- EQUIPE QUE RECEBERÁ OS CHAMADOS ABERTOS

---------------------

-- Tabela usuarios

-- Privilégios:
-- 
-- 0 - Usuário
-- 1 - Suporte
-- 2 - Administrador

CREATE TABLE usuarios(
    codigo int not null AUTO_INCREMENT,
    username varchar(30) not null,
    senha varchar(256) not null,
    privilegio int not null,
    codigoEquipe int not null,
    primary key(codigo),
    unique(username),
    foreign key(codigoEquipe) references equipe(codigo)
);

-- Adiciona o administrador ao sistema com usuário/senha: admin/admin
INSERT INTO usuarios(username,senha,privilegio,codigoEquipe) VALUES ('admin','admin', 2, 2);

---------------------

-- Tabela chamados
-- Dado de "estado":
-- 
-- 0 - Aberto
-- 1 - Suspenso
-- 2 - Encerrado

CREATE TABLE chamados(
    codigo int NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(75) NOT NULL,
	categoria VARCHAR(60) NOT NULL,
	localizacao VARCHAR(50) NOT NULL,
	nomeEstacao VARCHAR(50) NOT NULL,
	descricao VARCHAR(140) NOT NULL,
	abertoPor VARCHAR(30) NOT NULL,
	equipe int NOT NULL,
	responsavel int NOT NULL,
	estado smallint NOT NULL,
	primary key(codigo),
	foreign key(equipe) references equipe(codigo),
	foreign key(responsavel) references usuarios(codigo)
);
-- Insere um chamado de testes no sistema
INSERT INTO chamados(titulo,categoria,localizacao,nomeEstacao,descricao,abertoPor,equipe,responsavel,estado) VALUES ('CHAMADO TESTE','Instalação','TI','MICRO-TI','Solicito a instalação de Windows 3.11 em uma VM','admin',3,1,0);

-----------------------

-- Tabela registros
CREATE TABLE registros(
    codigoRegistro int NOT NULL AUTO_INCREMENT,
	autor varchar(30) NOT NULL,
	data varchar(10) NOT NULL,
	horario varchar(5) NOT NULL,
	registro varchar(240) NOT NULL,
	codigoChamado int NOT NULL,
	primary key(codigoRegistro),
	foreign key(codigoChamado) references chamados(codigo)
);
