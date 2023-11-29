package br.com.fineasy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fineasy.dao.ContaDAO;
import br.com.fineasy.dao.GastoDAO;
import br.com.fineasy.model.Categoria;
import br.com.fineasy.model.Conta;
import br.com.fineasy.utils.Sessions;

/**
 * Servlet implementation class SaldosExibirController
 */
@WebServlet("/Saldos")
public class SaldosExibirController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaldosExibirController() {
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
		
		
		Conta contaUltima = new ContaDAO().selectUltimaConta();
		int contaId = contaUltima.getId();
		Conta conta = new ContaDAO().selectConta(contaId);
		
		double entrada = conta.getEntrada();
		double gasto = conta.getGasto();
		request.setAttribute("entrada", entrada);
		request.setAttribute("gasto", gasto);
		
		GastoDAO gastoDAO = new GastoDAO();
		Categoria categoria = gastoDAO.selectTop3Gasto();
		request.setAttribute("top1", categoria.getCategoriaG().get(0));
		request.setAttribute("top2", categoria.getCategoriaG().get(1));
		request.setAttribute("top3", categoria.getCategoriaG().get(2));
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		}catch (Exception e) {
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
		doGet(request, response);
	}

}
