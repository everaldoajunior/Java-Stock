package br.com.estoqueJava.entidades;

public class Produtos {

	private int id;
	private String nomeProduto;
	private double precoCompra;
	private double precoVenda;
	private int quantidadeEstoque;
	private String loteMercadoria;
	private int idFornecedor;


	public Produtos() {
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getLoteMercadoria() {
		return loteMercadoria;
	}
	public void setLoteMercadoria(String loteMercadorias) {
		this.loteMercadoria = loteMercadorias;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}



}
