package business;
// Alguns dos clientes pode ser s�cios do bar e eleg�veis a um programa de milhagens. 
// Neste caso, deve-se registrar tamb�m o n�mero do s�cio.
public class Socio extends Cliente{
	
	String numSocio;
	public Socio(String nome, String CPF, int idade, char genero, String numSocio) {
		super(nome, CPF, idade, genero);
		this.numSocio = numSocio;
	}
	
}
