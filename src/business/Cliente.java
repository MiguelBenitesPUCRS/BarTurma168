package business;

public class Cliente {
	//cliente informe seu nome, CPF, idade e gênero. 
	private String nome;	//nome do cliente
	private String CPF;		//CPF do cliente
	private int idade;		//idade do cliente
	private char genero;	//genero do cliente M ou F
	private boolean noBar;	//se o cliente está no bar
	
	public Cliente() {
		this.nome = "Cliente";
		this.CPF = "99999999999";
		this.idade = 18;
		this.genero = 'M';
		this.noBar = true;
	}
	
	public Cliente(String nome, String cpf, int idade, char genero) {
		this.nome = nome;
		this.CPF = cpf;
		this.idade = idade;
		this.genero = genero;
		this.noBar = true;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public boolean isNoBar() {
		return noBar;
	}

	public void setNoBar(boolean noBar) {
		this.noBar = noBar;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CPF=" + CPF + ", idade=" + idade + ", genero=" + genero + ", noBar=" + noBar
				+ "]";
	}

}
