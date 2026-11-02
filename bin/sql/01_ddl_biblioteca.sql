-- ==========================================================
-- CARD 4.1: MODELAGEM RELACIONAL & DDL (Data Definition Language)
-- Projeto: Biblioteca Console
-- Banco: MySQL
-- ==========================================================

-- 1. Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

-- 2. Tabela de Membros (Usuários da Biblioteca)
CREATE TABLE IF NOT EXISTS membros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    ativo BOOLEAN DEFAULT TRUE
);

-- 3. Tabela de Livros
CREATE TABLE IF NOT EXISTS livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    ano_publicacao INT NOT NULL,
    emprestado BOOLEAN DEFAULT FALSE,
    vezes_emprestado INT DEFAULT 0
);

-- 4. Tabela de Empréstimos (Relacionamento N:N entre Membros e Livros)
CREATE TABLE IF NOT EXISTS emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_membro INT NOT NULL,
    id_livro INT NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    
    -- Constraints de Integridade Referencial (Foreign Keys)
    CONSTRAINT fk_emprestimo_membro FOREIGN KEY (id_membro) REFERENCES membros(id),
    CONSTRAINT fk_emprestimo_livro FOREIGN KEY (id_livro) REFERENCES livros(id)
);

