package br.com.fineasy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fineasy.model.Conta;
import br.com.fineasy.model.Gasto;

public class ContaDAO {


	 public Conta selectConta(int id){

		//Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conta conta = new Conta();
		Connection conexao;
		try {



            conexao = DBConnection.conexaoDB();


			String sqlGetConta = "SELECT DISTINCT CD_CONTA, NR_TOTAL_ENTRADA, NR_TOTAL_SAIDA FROM T_FINEASY_CONTA WHERE CD_CONTA = ? ORDER BY CD_CONTA";

			ps = conexao.prepareStatement(sqlGetConta);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while(rs.next()) {
				conta.setId(rs.getInt("CD_CONTA"));
				
				conta.setEntrada(rs.getInt("NR_TOTAL_ENTRADA"));
				
				conta.setGasto(rs.getInt("NR_TOTAL_SAIDA"));
				

			}

		DBConnection.closeconexao(conexao);
		DBConnection.closeconexaoPS(ps);
		DBConnection.closeconexaoRS(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}


		return conta;
	}
	 public Conta selectUltimaConta(){

			//Connection conexao = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Conta conta = new Conta();
			Connection conexao;
			
			try {

	            conexao = DBConnection.conexaoDB();


				String sqlGetConta = "SELECT DISTINCT CD_CONTA, NR_TOTAL_ENTRADA, NR_TOTAL_SAIDA FROM T_FINEASY_CONTA ORDER BY CD_CONTA DESC";

				ps = conexao.prepareStatement(sqlGetConta);
				rs = ps.executeQuery();

				if(rs.next()) {
				conta.setId(rs.getInt("CD_CONTA"));
				conta.setEntrada(rs.getInt("NR_TOTAL_ENTRADA"));
				conta.setGasto(rs.getInt("NR_TOTAL_SAIDA"));}
			
			DBConnection.closeconexao(conexao);
			DBConnection.closeconexaoPS(ps);
			DBConnection.closeconexaoRS(rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}


			return conta;
		}

	 public void insertConta(double saldo, double nr_total_entrada, double nr_total_saida){

		Conta conta = null;
		Connection conexao = null;
		PreparedStatement ps = null;

		try {

			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();
			String sqlInsert = "INSERT INTO T_FINEASY_CONTA (CD_CONTA, NR_TOTAL_ENTRADA, NR_TOTAL_SAIDA) VALUES (SQ_FINEASY_CONTA.NEXTVAL, ?, ?)";


			ps = conexao.prepareStatement(sqlInsert);
			ps.setDouble(1, nr_total_entrada);
			ps.setDouble(2, nr_total_saida);
			conta = new Conta(saldo, nr_total_entrada, nr_total_saida);
			ps.execute();






		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		

	public void UpdateContaGasto(double gasto) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ContaDAO contaDAO = new ContaDAO();
		

		try {
			conexao = DBConnection.conexaoDB();

			String sqlUpdate = "UPDATE T_FINEASY_CONTA SET NR_TOTAL_SAIDA = ? WHERE CD_CONTA = ?";
			ps = conexao.prepareStatement(sqlUpdate);
			Conta contaId = contaDAO.selectUltimaConta();
			ps.setDouble(1, gasto);
			ps.setInt(2, contaId.getId());
			ps.executeUpdate();

			DBConnection.closeconexao(conexao);
			DBConnection.closeconexaoPS(ps);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void UpdateContaEntrada(double entrada) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ContaDAO contaDAO = new ContaDAO();

		try {
			conexao = DBConnection.conexaoDB();

			String sqlUpdate = "UPDATE T_FINEASY_CONTA SET NR_TOTAL_ENTRADA = ? WHERE CD_CONTA = ?";
			ps = conexao.prepareStatement(sqlUpdate);
			Conta contaId = contaDAO.selectUltimaConta();
			ps.setDouble(1, entrada);
			ps.setInt(2, contaId.getId());
			ps.executeUpdate();

			DBConnection.closeconexao(conexao);
			DBConnection.closeconexaoPS(ps);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void DeleteConta(int cd_conta) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlDelete = "";
			ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, cd_conta);
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




