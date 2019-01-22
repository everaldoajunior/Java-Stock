package br.com.estoqueJava.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estoqueJava.entidades.Fornecedor;
import br.com.estoqueJava.entidades.Produtos;

public class FornecedoresDAO {
	
	private final Connection connection;

	public FornecedoresDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean inserir(Fornecedor obj) throws SQLException {
		
		
		String sql = "INSERT INTO tb_produtos (razaoSocial, emailFornecedor, telefone) VALUES (?,?,?)";
		try(PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, obj.getRazaoSocial());
			pst.setString(1, obj.getEmail());
			pst.setString(2, obj.getTelefone());

			pst.execute();

			try(ResultSet rst = pst.getGeneratedKeys()) {
				if(rst.first()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;

	}

	
	public List<Fornecedor> listarFornecedores() throws SQLException {
		String sql = "SELECT * FROM tb_produtos";
		List<Fornecedor> listaFornecedores = new ArrayList<>();

		try(PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.execute();

			try(ResultSet rst = pst.getResultSet()) {
				do  
				{
					Fornecedor fornecedor = new Fornecedor();
					
					fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
					fornecedor.setEmail(rst.getString("emailFornecedor"));
					fornecedor.setTelefone(rst.getString("telefone"));
					

					listaFornecedores.add(fornecedor);

				} while (rst.next());
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
				connection.close();
			}

		}

		return listaFornecedores;
	}
	
	public boolean deletar(Produtos obj) throws SQLException {
		String sql = "DELETE FROM tb_fornecedores WHERE ID = ?";

		try(PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setInt(1, obj.getId());

			pst.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return false;
	}


	public boolean atualizar(Fornecedor obj) throws SQLException {
		String sql = "UPDATE tb_fornecedores SET nomeFornecedor = ?, emailFornecedor = ?, telefone = ? WHERE ID = ?";

		try(PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, obj.getRazaoSocial());
			pst.setString(2, obj.getEmail());
			pst.setString(3, obj.getTelefone());
			

			pst.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return false;
	}
	
}
