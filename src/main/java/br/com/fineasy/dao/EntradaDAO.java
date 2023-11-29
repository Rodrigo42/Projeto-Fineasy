package br.com.fineasy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import br.com.fineasy.model.*;


public class EntradaDAO {

	public static void insertEntrada(double nr_entrada, String nm_categoria) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		try {

			conexao = DBConnection.conexaoDB();
			String sqlInsert = "INSERT INTO T_FINEASY_ENTRADA (CD_ENTRADA, NR_ENTRADA, NM_CATEGORIA, CD_CONTA) VALUES (SQ_FINEASY_ENTRADA.NEXTVAL, ?, ?, ?)";

			conta = contaDAO.selectUltimaConta();
			ps = conexao.prepareStatement(sqlInsert);
			ps.setDouble(1, nr_entrada);
			ps.setString(2, nm_categoria);
			ps.setInt(3, conta.getId());

			ps.execute();

			ps.close();

			System.out.println("Registro realizado.");

		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBConnection.closeconexao(conexao);
		DBConnection.closeconexaoPS(ps);

		}

	public List<Entrada> selectEntrada() {
		List<Entrada> entradas = new ArrayList<Entrada>();
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		
		try {
			conexao = DBConnection.conexaoDB();

			String sqlGetUsuario = "SELECT DISTINCT CD_ENTRADA, NR_ENTRADA, NM_CATEGORIA, CD_CONTA FROM T_FINEASY_ENTRADA WHERE CD_CONTA = ? ORDER BY CD_ENTRADA";
			conta = contaDAO.selectUltimaConta();
			ps = conexao.prepareStatement(sqlGetUsuario);
			ps.setInt(1, conta.getId()); 
			rs = ps.executeQuery();

			while(rs.next()) {
				int id =  rs.getInt("CD_ENTRADA"); 
				double valorDeEntrada = rs.getDouble("NR_ENTRADA");
				String catEntrada = rs.getString("NM_CATEGORIA"); 
				
				Entrada entrada = new Entrada( id, valorDeEntrada, catEntrada);
				entradas.add(entrada);
			}
			
		DBConnection.closeconexao(conexao);
		DBConnection.closeconexaoPS(ps);
		DBConnection.closeconexaoRS(rs);

		}catch(SQLException e){
			e.printStackTrace();
		}
		return entradas;
	}

	private static void updateEntrada(int nr_entrada, String nm_categoria) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = DBConnection.conexaoDB();

			String sqlUpdate = "";
			ps = conexao.prepareStatement(sqlUpdate);
			ps.setInt(1, nr_entrada);
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void removeUsuario(int cd_entrada) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlDelete = "DELETE FROM T_FINEASY_ENTRADA WHERE CD_ENTRADA = ? CASCADE CONSTRAINTS";
			ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, cd_entrada);
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conexao.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	


}
