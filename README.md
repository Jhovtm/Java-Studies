# Projeto JDBC

Projeto de estudo em Java 21 usando JDBC e MariaDB. A conexão padrão aponta para `localhost:3306/basejdbc`, com usuário `root` sem senha.

## Preparar o banco

1. Instale e inicie o MariaDB.
2. Abra `SCRIPT.sql` no cliente MariaDB/MySQL e execute-o. O script cria o banco e as tabelas sem apagar dados existentes; os três produtos de exemplo só são inseridos se ainda não existirem.
3. No Eclipse, importe esta pasta como **Existing Projects into Workspace**. O driver MariaDB já está em `lib/` e referenciado no `.classpath`.
4. Execute uma das classes em `src/br/com/cefet/projeto/testes` como **Java Application**.

Para outro endereço ou credenciais, configure as variáveis de ambiente `JDBC_URL`, `JDBC_USER` e `JDBC_PASSWORD` na configuração de execução do Eclipse. Exemplo de URL: `jdbc:mariadb://localhost:3306/basejdbc`.

As classes `TestaInsert`, `TestaInsert2`, `TestaListar`, `TestaObterEAlterar` e `TestaRemover` demonstram operações com a tabela `produto`. `TestaProduto` demonstra a classe de domínio sem precisar de banco de dados.
