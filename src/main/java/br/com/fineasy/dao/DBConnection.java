package br.com.fineasy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {


	public static Connection conexaoDB(){
		// Inicializando nulo para obter retorno
        Connection conexao = null;

        try { // Tenta conectar no banco

            // Driver do JDBC da classe DriverManager
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Com o driver do Oracle já inserido pegando a variavel conexao e passando as credenciais do Oracle
            conexao = DriverManager.getConnection(
            		"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM552501", "270697"
            );
        }
        // Caso ocorra algo erro jogar na pilha de execução
        catch(Exception erro){
            erro.printStackTrace();
        }
        return conexao;
	}

	public DBConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void closeconexao(Connection c) {
		if(c == null) {
			return;
		}
		try {
			c.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeconexaoPS(PreparedStatement c) {
		if(c == null) {
			return;
		}
		try {
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeconexaoRS(ResultSet c) {
		if(c == null) {
			return;
		}
		try {
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
