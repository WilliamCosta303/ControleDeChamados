package com.github.williamcosta303.modelo;

import java.sql.*;

public class Conexao {
    // Atributos
    private static final String url = "jdbc:mysql://localhost:3306/chamados";
    private static final String usuario = "root";
    private static final String senha = /*""*/"123";
    
    public static Connection conecta() throws SQLException{
        try{
            return DriverManager.getConnection(url, usuario, senha);
        }catch(SQLException SE){
            throw new SQLException("Erro na conexão com o banco de dados\nCausa: " + SE.getMessage());
        }
    }
}
