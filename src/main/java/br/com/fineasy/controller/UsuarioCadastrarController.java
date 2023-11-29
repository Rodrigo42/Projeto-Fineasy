package br.com.fineasy.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fineasy.dao.UsuarioDAO;
import br.com.fineasy.model.Usuario;


/**
 * Servlet implementation class UsuarioCadastrarController
 */
@WebServlet("/Cadastro")
public class UsuarioCadastrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioCadastrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setDataDeNascimento(Date.valueOf(request.getParameter("nasc")));
		usuario.setTelefone(request.getParameter("tel")); 
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.insertUsuario(usuario.getEmail(), usuario.getSenha(), usuario.getNome(), usuario.getTelefone(), usuario.getDataDeNascimento());
		response.sendRedirect("login.jsp");
		
		
		
	}

}
