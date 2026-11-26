package br.com.cefet.projeto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DEFAULT_URL =
            "jdbc:mariadb://localhost:3306/basejdbc?useUnicode=true&characterEncoding=UTF-8";

    public Connection getConexao() {
        String url = System.getenv().getOrDefault("JDBC_URL", DEFAULT_URL);
        String user = System.getenv().getOrDefault("JDBC_USER", "root");
        String password = System.getenv().getOrDefault("JDBC_PASSWORD", "");

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException(
                    "Não foi possível conectar ao banco. Confira o MariaDB, o banco basejdbc "
                            + "e as variáveis JDBC_URL, JDBC_USER e JDBC_PASSWORD.",
                    e);
        }
    }
}
