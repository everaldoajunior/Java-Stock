package br.com.estoqueJava.entidades;

public class Fornecedor {

	private int id;
	private String razaoSocial;
	private String email;
	private String telefone;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emailFornecedor) {
		this.email= emailFornecedor;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}

	
}
