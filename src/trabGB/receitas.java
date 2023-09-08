package trabGB;

public class receitas {
	
	private String descricao;
	private String data;
	private double valor;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public receitas(String descricao, String data, double valor) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
	}
	
	public receitas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
