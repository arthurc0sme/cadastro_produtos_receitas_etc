package trabGB;


public class cliente {
	protected String nome;
	protected String cpf;
	protected String endereço;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setRua(String endereço) {
		this.endereço = endereço;
	}
	public cliente(String nome, String cpf, String endereço) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereço = endereço;
	}
	
}
