package br.com.fineasy.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fineasy.model.Usuario;

public class Sessions {

	public Sessions() {
		// TODO Auto-generated constructor stub
	}
	public static void validarLogin(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado == null) {
			throw new Exception("Login expirado!");
		}
	}

}
