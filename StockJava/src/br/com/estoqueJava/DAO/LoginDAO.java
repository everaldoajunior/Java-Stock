package br.com.estoqueJava.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estoqueJava.entidades.Login;

public class LoginDAO {

	private static Connection connection;

	public LoginDAO(Connection connection) {
		LoginDAO.connection = connection;
	}

	public static boolean consultaLogin(Login obj) throws SQLException {

		String sql = "SELECT * FROM tb_usuarios WHERE login = ? AND senha = ? ";

		try(PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getSenha());

			pst.execute();

			try(ResultSet rst = pst.getGeneratedKeys()) {
				if(rst.first()) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		}
	}
}





