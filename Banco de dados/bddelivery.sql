-- TABELA: cadastro

CREATE TABLE cadastro (

	id SERIAL PRIMARY KEY,
	usuario VARCHAR(12) NOT NULL,
	senha VARCHAR(10) NOT NULL
);

-- TABELA: cliente
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

-- TABELA: endereco
CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(10),
    rua VARCHAR(100),
    cidade VARCHAR(100),
    cep VARCHAR(10),
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- TABELA: restaurante
CREATE TABLE restaurante (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(150),
    cnpj VARCHAR(14) UNIQUE,
    telefone VARCHAR(20),
    categoria VARCHAR(50)
);

-- TABELA: produto
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(50),
    restaurante_id INT,
    FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
);

-- TABELA: entregador
CREATE TABLE entregador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(11) UNIQUE,
    telefone VARCHAR(20),
    veiculo VARCHAR(50),
    status VARCHAR(20)
);

-- TABELA: pedido
CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50),
    subtotal DECIMAL(10,2) NOT NULL DEFAULT 0,
    desconto DECIMAL(10,2),
    taxa_entrega DECIMAL(10,2),
    total DECIMAL(10,2),

    cliente_id INT NOT NULL,
    endereco_id INT NOT NULL,
    entregador_id INT,
    restaurante_id INT NOT NULL,

    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(id),
    FOREIGN KEY (entregador_id) REFERENCES entregador(id),
    FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
);

-- TABELA: item_pedido
CREATE TABLE item_pedido (
    id SERIAL PRIMARY KEY,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,

    pedido_id INT,
    produto_id INT,

    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
