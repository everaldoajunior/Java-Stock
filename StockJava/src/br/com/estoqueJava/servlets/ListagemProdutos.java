package br.com.estoqueJava.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estoqueJava.Conexao.Conexao;
import br.com.estoqueJava.DAO.ProdutosDAO;


@WebServlet("/listagemProdutos")
public class ListagemProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List listaProdutos = null;

		try {

			ProdutosDAO produtos = new ProdutosDAO(Conexao.getConnection());
			listaProdutos = produtos.listarProdutos();
			request.setAttribute("listaProdutos", listaProdutos);
			RequestDispatcher rd = request.getRequestDispatcher("listaProdutos.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
