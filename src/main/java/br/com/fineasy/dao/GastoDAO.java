package br.com.fineasy.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fineasy.model.Categoria;
import br.com.fineasy.model.Conta;
import br.com.fineasy.model.Gasto;

public class GastoDAO {

	public void insertGasto(double nr_gasto, String nm_categoria_gasto) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		
		try {

			conexao = DBConnection.conexaoDB();
			String sqlInsert = "INSERT INTO T_FINEASY_GASTO (CD_GASTO, NR_GASTO, NM_CATEGORIA_GASTO, CD_CONTA) VALUES (SQ_FINEASY_GASTO.NEXTVAL, ?, ?, ?)";

			conta = contaDAO.selectUltimaConta();
			ps = conexao.prepareStatement(sqlInsert);
			ps.setDouble(1, nr_gasto);
			ps.setString(2, nm_categoria_gasto);
			ps.setInt(3, conta.getId());
			
			ps.execute();

			System.out.println("Registro realizado.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBConnection.closeconexao(conexao);
		DBConnection.closeconexaoPS(ps);

		}

	public Categoria selectTop3Gasto() {
		Connection conexao;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categoria categoria = new Categoria();
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		try {
			conexao = DBConnection.conexaoDB();

			String sqlGetUsuario = "SELECT ROWNUM as RANK, NM_CATEGORIA_GASTO\r\n"
					+ "    FROM(SELECT NM_CATEGORIA_GASTO FROM T_FINEASY_GASTO WHERE CD_CONTA= ? ORDER BY NR_GASTO) WHERE ROWNUM <=3";
			conta = contaDAO.selectUltimaConta();
			int contaId = conta.getId();
			ps = conexao.prepareStatement(sqlGetUsuario);
			ps.setInt(1, contaId);
			rs = ps.executeQuery();

			while(rs.next()) {
				categoria.setCategoriaG(rs.getString("NM_CATEGORIA_GASTO"));
				}
			
			
				conexao.close();
				ps.close();
				rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return categoria;




	}

	public List<Gasto> selectGasto() {
		List<Gasto> gastos = new ArrayList<Gasto>();
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conexao = DBConnection.conexaoDB();

			String sqlSelectGasto = "SELECT DISTINCT CD_GASTO, NR_GASTO, NM_CATEGORIA_GASTO, CD_CONTA FROM T_FINEASY_GASTO WHERE CD_CONTA = 3 ORDER BY CD_GASTO";

			ps = conexao.prepareStatement(sqlSelectGasto);
			rs = ps.executeQuery();

			while(rs.next()) {
				int id =  rs.getInt("CD_GASTO"); 
				double saldoDeGasto = rs.getDouble("NR_GASTO");
				String categoriaDeGasto = rs.getString("NM_CATEGORIA_GASTO"); 
				
				Gasto gasto = new Gasto( id, saldoDeGasto, categoriaDeGasto);
				gastos.add(gasto);
			}
			
			
		DBConnection.closeconexao(conexao);
		DBConnection.closeconexaoPS(ps);
		DBConnection.closeconexaoRS(rs);

		}catch(SQLException e){
			e.printStackTrace();
		}
		return gastos;
	}

	private static void updateGasto(int nr_gasto, String nm_categoria_gasto) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlUpdate = "";
			ps = conexao.prepareStatement(sqlUpdate);
			ps.setInt(1, nr_gasto);
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

	private static void removeUsuario(int cd_gasto) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlDelete = "DELETE FROM T_FINEASY_GASTO WHERE CD_GASTO = ? CASCADE CONSTRAINTS";
			ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, cd_gasto);
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


