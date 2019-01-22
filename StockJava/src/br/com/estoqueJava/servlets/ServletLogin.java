package br.com.estoqueJava.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estoqueJava.DAO.LoginDAO;
import br.com.estoqueJava.entidades.Login;

@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeUsuario = (String) request.getAttribute("nomeUsuario");
		String senhaUsuario = (String) request.getAttribute("senhaUsuario");

		Login login = new Login();
		login.setNome(nomeUsuario);
		login.setSenha(senhaUsuario);

		try {
			boolean resultado = LoginDAO.consultaLogin(login);
			if (resultado == true ) {
				RequestDispatcher rd = request.getRequestDispatcher("framePrincipal.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("frameSenhaErrada.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
