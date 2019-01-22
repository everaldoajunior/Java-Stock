package br.com.estoqueJava.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estoqueJava.entidades.Usuario;

public class UsuarioDAO {
	
	private static Connection connection;
	
	public UsuarioDAO(Connection connection) {
		UsuarioDAO.connection = connection;
		
	}
	
	public static boolean inserir(Usuario obj) throws SQLException {
		
		String sql = "INSERT INTO tb_usuarios(nome,usuario,senha) values (?,?,?)";
		try(PreparedStatement pst = connection.prepareStatement(sql)){
			
			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getUsuario());
			pst.setString(3, obj.getSenha());
			
			pst.execute();
			
			try(ResultSet rst = pst.getGeneratedKeys()){
				if(rst.first()) {
					return true;
				}
			
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}return false;
	}

}
