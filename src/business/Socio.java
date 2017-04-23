package business;
// Alguns dos clientes pode ser sócios do bar e elegíveis a um programa de milhagens. 
// Neste caso, deve-se registrar também o número do sócio.
public class Socio extends Cliente{
	
	String numSocio;
	public Socio(String nome, String CPF, int idade, char genero, String numSocio) {
		super(nome, CPF, idade, genero);
		this.numSocio = numSocio;
	}
	
}
