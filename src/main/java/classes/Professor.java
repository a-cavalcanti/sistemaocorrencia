package classes;


public class Professor {
	
	private int codigo;
	private String nome;
	private String formacao;
	private int siape;
	private String senha;
	private String funcao;
	
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getCodigo() {	
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public int getSiape() {
		return siape;
	}
	public void setSiape(int siape) {
		this.siape = siape;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
