package business;

import java.util.ArrayList;

public class Bar {

	private Cliente cliente;

	private int qtdClientes; // controla a qtd de clientes que entraram no bar
	private int qtdMasculinos; // controla a qtd de homens
	private int qtdFemininos; // controla a qtd de mulheres
	private int qtdSocios; // controla a qtd de socios
	private int qtdNaoSocios; // controla a qtd de não socios

	ArrayList<Cliente> clientes = new ArrayList<>();

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void Cliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getQtdClientes() {
		int qtd=0;
		for(int i=0;i<clientes.size();i++){
			if(clientes.get(i).isNoBar()==true){
				qtd++;
			}
		}
		qtdClientes = qtd;
		return qtdClientes;
	}

	public void addQtdClientes() {
		qtdClientes++;
	}

	public int getQtdMasculinos() {
		return qtdMasculinos;
	}

	public void addQtdMasculinos() {
		qtdMasculinos++;
	}

	public int getQtdFemininos() {
		return qtdFemininos;
	}

	public void addQtdFemininos() {
		qtdFemininos++;
	}

	public int getQtdSocios() {
		return qtdSocios;
	}

	public void addQtdSocios() {
		qtdSocios++;
	}

	public int getQtdNaoSocios() {
		return qtdNaoSocios;
	}

	public void addQtdNaoSocios() {
		qtdNaoSocios++;
	}

	// Adciona o cliente no array
	public void addCliente(Cliente cliente) {

		// Acerta o genero...
		if (cliente.getGenero() == 'M') {
			addQtdMasculinos();
		} else {
			addQtdFemininos();
		}

		// Acerta o sócio...
		if (cliente instanceof Socio) {
			addQtdSocios();
		} else {
			addQtdNaoSocios();
		}

		addQtdClientes();
		clientes.add(cliente);
	}

	// Remove o cliente apenas seta a variável noBar com false
	public void removeCliente(String cpf) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCPF().equals(cpf)) {
				clientes.get(i).setNoBar(false);
			}
		}
	}

	// consulta o cliente pelo número do CPF
	public Cliente consultaCliente(String cpf) {
		Cliente auxCliente;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCPF().equals(cpf)) {
				if(clientes.get(i).isNoBar()==true){
					return auxCliente = clientes.get(i);
				}		
			}
		}
		return null;
	}

	// percentual de masculino
	public int getPercentualMasculino() {
		return (int)(((double)getQtdMasculinos() / (double)getQtdClientes()) * 100);
	}

	// percentual de feminino
	public int getPercentualFeminino(){
		return (int)(((double)getQtdFemininos() / (double)getQtdClientes()) * 100);
	}

	@Override 
	public String toString() {
		String cli;
		cli = "Clientes [";
		for(int i=0;i<clientes.size();i++){
			if(!(i+1==clientes.size())){
				cli = cli + clientes.get(i).getNome() + ", ";
			}else{
				cli = cli + clientes.get(i).getNome() + "]";
			}
		}
		return cli;
	}
	
}
