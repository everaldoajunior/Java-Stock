package br.com.estoqueJava.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estoqueJava.entidades.Produtos;

public class ProdutosDAO {

	private final Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean inserir(Produtos obj) throws SQLException {
		
		
		String sql = "INSERT INTO tb_produtos (nomeProduto, precoCompra, precoVenda, quantidadeEstoque, loteMercadoria, idFornecedor) VALUES (?,?,?,?,?,?)";
		try(PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, obj.getNomeProduto());
			pst.setDouble(2, obj.getPrecoCompra());
			pst.setDouble(3, obj.getPrecoVenda());
			pst.setInt(4, obj.getQuantidadeEstoque());
			pst.setString(5, obj.getLoteMercadoria());
			pst.setInt(6, obj.getIdFornecedor());

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

	public List<Produtos> listarProdutos() throws SQLException {
		String sql = "SELECT * FROM tb_produtos";
		List<Produtos> listaProdutos = new ArrayList<>();

		try(PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.execute();

			try(ResultSet rst = pst.getResultSet()) {
				do  
				{
					Produtos produto = new Produtos();
					produto.setId(rst.getInt("id"));
					produto.setNomeProduto(rst.getString("nomeProduto"));
					produto.setPrecoCompra(rst.getDouble("precoCompra"));
					produto.setPrecoVenda(rst.getDouble("precoVenda"));
					produto.setQuantidadeEstoque(rst.getInt("quantidadeEstoque"));
					produto.setLoteMercadoria(rst.getString("loteMercadoria"));
					produto.setIdFornecedor(rst.getInt("idFornecedor"));

					listaProdutos.add(produto);

				} while (rst.next());
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
				connection.close();
			}

		}



		return listaProdutos;


	}


	public boolean deletar(Produtos obj) throws SQLException {
		String sql = "DELETE FROM tb_produtos WHERE ID = ?";

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


	public boolean atualizar(Produtos obj) throws SQLException {
		String sql = "UPDATE tb_produtos SET nomeProduto = ?, precoCompra = ?, precoVenda = ?, quantidadeEstoque = ? WHERE ID = ?";

		try(PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, obj.getNomeProduto());
			pst.setDouble(2, obj.getPrecoCompra());
			pst.setDouble(3, obj.getPrecoVenda());
			pst.setInt(4, obj.getQuantidadeEstoque());

			pst.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return false;
	}


}
