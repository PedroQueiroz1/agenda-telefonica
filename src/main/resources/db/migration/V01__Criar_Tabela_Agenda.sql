CREATE TABLE agenda (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	logradouro VARCHAR(30),
	numero INTEGER,
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('João Silva', '(34) 99261-4270', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-122', 'Uberlândia', 'MG');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Maria Rita', '(34) 99261-4270', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-122', 'Ribeirão Preto', 'SP');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Pedro Santos', '(34) 99261-4270', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-122', 'Goiânia', 'GO');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Ricardo Pereira', '(34) 99261-4270', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-122', 'Salvador', 'BA');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Josué Mariano', '(34) 99261-4270', 'Av Rio Branco', '321', null, 'Jardins', '56.400-122', 'Natal', 'RN');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Pedro Barbosa', '(34) 99261-4270', 'Av Brasil', '100', null, 'Tubalina', '77.400-123', 'Porto Alegre', 'RS');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Henrique Medeiros', '(34) 99261-4270', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-124', 'Rio de Janeiro', 'RJ');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Carlos Santana', '(34) 99261-4270', 'Rua da Manga', '433', null, 'Centro', '31.400-124', 'Belo Horizonte', 'MG');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Leonardo Oliveira', '(34) 99261-4270', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-005', 'Uberlândia', 'MG');
INSERT INTO agenda (nome, telefone, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Isabela Martins', '(34) 99261-4270', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-125', 'Manaus', 'AM');
