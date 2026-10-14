# 🚀 Pull Request — [Nome da Feature / Branch]

## 🎯 Objetivo
<!-- Descreva de forma clara e objetiva o que esta funcionalidade ou correção faz -->
- 

---

## 🔗 Issue Relacionada
<!-- Palavra-chave para fechar a issue automaticamente: Closes #numero ou Fixes #numero -->
- Closes #

---

## 📋 Regras de Negócio e Domínio
<!-- Marque o que foi contemplado nesta entrega -->
- [ ] Regra de negócio implementada diretamente na Entidade de domínio (`Livro` / `Membro`)
- [ ] Validações de integridade e tratamento de casos inválidos (ex: livro já emprestado, limite excedido)
- [ ] Atualização automática de estado com Dirty Checking do Hibernate
- [ ] Associação correta das entidades relacionais (`@ManyToOne` / `@OneToMany`)

---

## 🗄️ Impacto no Banco de Dados (MySQL & JPA)
- [ ] Mapeamento de tabelas/colunas verificado com o Hibernate (`persistence.xml`)
- [ ] Chave Estrangeira (FK) gerada e associada com integridade referencial
- [ ] Consultas JPQL executadas orientadas a objetos (sem SQL puro)

---

## 🧪 Testes Práticos Realizados
- [ ] Classe de teste executada com sucesso no IntelliJ (`Teste...JPA.java`)
- [ ] Transação controlada com abertura (`begin`), confirmação (`commit`) e `rollback` em falha
- [ ] Fechamento correto de recursos (`em.close()` e `FabricaEntityManager.fechar()`)
- [ ] Verificação visual dos dados gravados no banco MySQL

---

## 📂 Arquivos Alterados e Criados
<!-- Liste os principais arquivos modificados ou novos -->
- `src/main/java/com/biblioteca/...`

---

## 🛡️ Checklist de Boas Práticas (Code Review)
- [ ] Nomenclatura clara e legível em classes, métodos e atributos
- [ ] Sem comentários mortos ou código comentado no projeto
- [ ] Commits semânticos no padrão (`feat:`, `test:`, `refactor:`, `docs:`)
- [ ] Nenhuma pasta de build commitada (`bin/` e `target/` devidamente ignoradas)
