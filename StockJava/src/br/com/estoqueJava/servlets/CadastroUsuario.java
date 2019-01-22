package br.com.estoqueJava.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estoqueJava.DAO.UsuarioDAO;
import br.com.estoqueJava.entidades.Usuario;

/**
 * Servlet implementation class CadastroUsuario
 */
@WebServlet("/cadastroUsuario")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUsuario = (String) request.getParameter("nomeUsuario");
		String usuario = (String) request.getParameter("usuario");
		String senha = (String) request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setNome(nomeUsuario);
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		try{
			
			boolean resultado = UsuarioDAO.inserir(user);
			
			if(resultado == true) {
				
				RequestDispatcher rd = request.getRequestDispatcher("listaUsuario.jsp");
			
			}else {
				
				RequestDispatcher rd = request.getRequestDispatcher("cadastroUsuario.jsp");
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			
			
		}
		
	
	}
	

}
