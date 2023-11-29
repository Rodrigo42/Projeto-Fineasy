package br.com.fineasy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fineasy.dao.ContaDAO;
import br.com.fineasy.dao.EntradaDAO;
import br.com.fineasy.model.Conta;
import br.com.fineasy.model.Entrada;
import br.com.fineasy.utils.Sessions;
/**
 * Servlet implementation class EntradaInserirController
 */
@WebServlet("/Entrada")
public class EntradaInserirController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntradaInserirController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Sessions.validarLogin(request);
			
					request.getRequestDispatcher("entrada.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp?erro=" + e.getMessage());
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		double valor = Double.parseDouble(request.getParameter("valor"));
		String categoria = request.getParameter("cat");

		Entrada entrada = new Entrada();
		entrada.setSaldoDeEntrada(valor);
		entrada.setCategoriaDeEntrada(categoria);
		EntradaDAO.insertEntrada(entrada.getSaldoDeEntrada(), entrada.getCategoriaEntrada());
		
		Conta contaUltima = new ContaDAO().selectUltimaConta();
		int contaId = contaUltima.getId();
		Conta conta = new ContaDAO().selectConta(contaId);
		double entradaSaldo = conta.getEntrada();
		entradaSaldo += valor;
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.UpdateContaEntrada(entradaSaldo);
		response.sendRedirect("/Fineasy/Saldos");
	}

}
