-- ==========================================================
-- CARD 4.1: CONSULTAS E RELATÓRIOS (DML & JOINs)
-- Projeto: Biblioteca Console
-- Banco: MySQL
-- ==========================================================

USE biblioteca_db;

-- 1. Consultas Básicas
-- Visualiza todos os registros cadastrados
SELECT * FROM membros;
SELECT * FROM livros;
SELECT * FROM emprestimos;

-- 2. INNER JOIN (Interseção)
-- Retorna apenas os membros que possuem livros emprestados no momento
SELECT 
    membros.nome AS membro,
    livros.titulo AS livro,
    emprestimos.data_emprestimo
FROM emprestimos
INNER JOIN membros ON emprestimos.id_membro = membros.id
INNER JOIN livros ON emprestimos.id_livro = livros.id;

-- 3. LEFT JOIN (Prioridade para a tabela da esquerda)
-- Retorna TODOS os membros cadastrados, inclusive quem ainda não pegou nenhum livro (exibe NULL)
SELECT 
    membros.nome AS membro,
    livros.titulo AS livro,
    emprestimos.data_emprestimo
FROM membros
LEFT JOIN emprestimos ON membros.id = emprestimos.id_membro
LEFT JOIN livros ON emprestimos.id_livro = livros.id;

-- 4. Agrupamento e Agregação (GROUP BY + COUNT)
-- Relatório: Quantos livros cada membro já pegou emprestado no total
SELECT 
    membros.nome AS membro,
    COUNT(emprestimos.id) AS total_livros_emprestados
FROM membros
LEFT JOIN emprestimos ON membros.id = emprestimos.id_membro
GROUP BY membros.id, membros.nome;

