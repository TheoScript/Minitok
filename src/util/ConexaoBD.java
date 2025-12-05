package util;

import java.sql.*;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/minitok";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco!", e);
        }
    }

    }

