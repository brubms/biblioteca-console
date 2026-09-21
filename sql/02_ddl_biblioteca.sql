USE biblioteca_db;

INSERT INTO membros (nome,email) VALUES ('Bruno','brunoberna21@gmail.com');
INSERT INTO membros (nome, email) VALUES ('Laiana','lainapmartins@gmail.com');
INSERT INTO livros (titulo, autor, ano_publicacao) VALUES ('Entendendo algoritimos','autor desconhecido', 2007 ),('Destrua esse diario','desconhecido',2009);

INSERT INTO emprestimos (id_membro, id_livro, data_emprestimo) VALUES (1,1,'2026-09-14');