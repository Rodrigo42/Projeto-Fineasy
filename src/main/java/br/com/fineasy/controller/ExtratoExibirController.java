package br.com.fineasy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fineasy.dao.EntradaDAO;
import br.com.fineasy.dao.GastoDAO;
import br.com.fineasy.model.Entrada;
import br.com.fineasy.model.Gasto;
import br.com.fineasy.utils.Sessions;

/**
 * Servlet implementation class ExtratoExibirController
 */
@WebServlet("/ExtratoLista")
public class ExtratoExibirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtratoExibirController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Sessions.validarLogin(request);
			request.getRequestDispatcher("Extrato.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp?erro=" + e.getMessage());
			
		}
		
		/*request.setAttribute("id", entrada.getId());
		request.setAttribute("valor", entrada.getSaldoDeEntrada());
		request.setAttribute("categoria", entrada.getCategoriaEntrada());*/
		
		/*String option = request.getParameter("extratoOpt");
		System.out.println(option);
		
		
		if(option.equalsIgnoreCase("optEntradas")) {
			List<Entrada> entrada = new EntradaDAO().selectEntrada();
			request.setAttribute("resultado", entrada);
			System.out.println("entrou!");
			
			
		}else if(option.equalsIgnoreCase("optGastos")) {
			List<Gasto> gasto = new GastoDAO().selectGasto();
			request.setAttribute("resultado", gasto);
			request.getRequestDispatcher("Extrato.jsp").forward(request, response);
			
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("extratoOpt");
		
		
		if(option.equalsIgnoreCase("optEntradas")) {
			
			List<Entrada> entrada = new EntradaDAO().selectEntrada();
			boolean opt = true;
			request.setAttribute("resultado", entrada);
			request.setAttribute("opt", opt);
			System.out.println("entrada!");
			request.getRequestDispatcher("Extrato.jsp").forward(request, response);
			
		}else if(option.equalsIgnoreCase("optGastos")) {
			List<Gasto> gasto = new GastoDAO().selectGasto();
			boolean opt = false;
			request.setAttribute("opt", opt);
			request.setAttribute("resultado", gasto);
			System.out.println("gasto!");
			request.getRequestDispatcher("Extrato.jsp").forward(request, response);
			
		}
	}

}
