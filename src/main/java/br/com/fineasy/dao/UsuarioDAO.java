package br.com.fineasy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fineasy.model.Conta;
import br.com.fineasy.model.Usuario;
public class UsuarioDAO {
	private static void getUsuario() {

		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlGetUsuario = "SELECT DISTINCT CD_USUARIO, DS_EMAIL, NM_SENHA, NM_NOME, NR_TELEFONE, DT_ANIVERSARIO, CD_CONTA FROM T_FINEASY_USUARIO ORDER BY CD_USUARIO";

			ps = conexao.prepareStatement(sqlGetUsuario);
			rs = ps.executeQuery();

			while(rs.next()) {
				int cd_usuario = rs.getInt("CD_USUARIO");
				String ds_email = rs.getString("DS_EMAIL");
				String nm_senha = rs.getString("NM_SENHA");
				String nm_nome = rs.getString("NM_NOME");
				int nr_telefone = rs.getInt("NR_TELEFONE");
				Date dt_aniv = rs.getDate("DT_ANIVERSARIO");
				int cd_conta = rs.getInt("CD_CONTA");

				System.out.println(cd_usuario + " " + ds_email + " " + nm_senha + " " + nm_nome + " " + nr_telefone + " " + dt_aniv + " " + cd_conta);
			}


		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				ps.close();
				rs.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public Usuario fazerLogin(String email, String senha) {

		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conexao = DBConnection.conexaoDB();

			String sqlGetUsuario = "SELECT DS_EMAIL, NM_SENHA FROM T_FINEASY_USUARIO";

			ps = conexao.prepareStatement(sqlGetUsuario);
			rs = ps.executeQuery();

			while(rs.next()) {
				String ds_email = rs.getString("DS_EMAIL");
				String nm_senha = rs.getString("NM_SENHA");
				Usuario usuario = new Usuario(ds_email, nm_senha);
				
				if((email.equals(ds_email)) && (senha.equals(nm_senha) )) {
					return usuario;
				}
			}


		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public void insertUsuario(String ds_email, String nm_senha, String nm_nome, String nr_telefone, java.util.Date date) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ContaDAO contaDAO = new ContaDAO();
		GastoDAO gastoDAO = new GastoDAO();
		try {

			conexao = DBConnection.conexaoDB();
			String sqlInsert = "INSERT INTO T_FINEASY_USUARIO (CD_USUARIO, DS_EMAIL, NM_SENHA, NM_NOME, NR_TELEFONE, DT_ANIVERSARIO, CD_CONTA) VALUES (SQ_FINEASY_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			contaDAO.insertConta(0, 0, 0);
			Conta contaId = contaDAO.selectUltimaConta();
			
			for(int i=0; i<=4; i++) {
				gastoDAO.insertGasto(1, "Vazio");
			}
			
			ps = conexao.prepareStatement(sqlInsert);
			ps.setString(1, ds_email);
			ps.setString(2, nm_senha);
			ps.setString(3, nm_nome);
			ps.setString(4, nr_telefone);
			ps.setDate(5, (Date) date);
			ps.setInt(6, contaId.getId());
			ps.execute();

			DBConnection.closeconexao(conexao);
			DBConnection.closeconexaoPS(ps);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void updateUsuario(String ds_email, String nm_senha, String nm_nome, int nr_telefone, Date dt_aniv) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlUpdate = "";
			ps = conexao.prepareStatement(sqlUpdate);
			ps.setString(1, ds_email);
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

	private static void removeUsuario(int cd_usuario) {
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = br.com.fineasy.dao.DBConnection.conexaoDB();

			String sqlDelete = "DELETE FROM T_FINEASY_USUARIO WHERE CD_USUARIO = ? CASCADE CONSTRAINTS";
			ps = conexao.prepareStatement(sqlDelete);
			ps.setInt(1, cd_usuario);
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







	public static void main(String[] Args) {
		getUsuario();
	}
}
