package tests;

import java.util.ArrayList;

import business.Bar;
import business.Cliente;
import business.Socio;

public class AppBar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Cliente(String nome, String cpf, int idade, char genero)
		Cliente cli1 = new Cliente("Evandro", "12345678901", 30, 'M');
		Cliente cli2 = new Cliente("Temis", "12345676901", 28, 'F');
		Cliente cli3 = new Socio("Graxa", "12349678901", 30, 'M', "1234");

		Bar bar = new Bar();
		
		bar.addCliente(cli1);
		bar.addCliente(cli2);
		bar.addCliente(cli3);
		
		
		System.out.println("Pessoas entraram no bar  :"+bar.toString());
		System.out.println("Qtd pessoas entraram     :"+bar.getQtdClientes());
		System.out.println("Qtd masculinos           :"+bar.getQtdMasculinos());
		System.out.println("Qtd femininos            :"+bar.getQtdFemininos());
		System.out.println("CPf 12349678901          :"+bar.consultaCliente("12349678901"));
		System.out.println("Qtd Socios               :"+bar.getQtdSocios());
		System.out.println("Qtd Não Socios           :"+bar.getQtdNaoSocios());
		System.out.println("% de Masculinos          :"+bar.getPercentualMasculino());
		System.out.println("% de Femininos           :"+bar.getPercentualFeminino());
		
		
//		System.out.println("Remove  cli3    :");
//		bar.removeCliente(cli3);
//		
//		System.out.println("Qtd pessoas     :"+bar.qtdPessoasNoBar());
//		System.out.println("Qtd masculinos  :"+bar.returnMasculinos());
//		System.out.println("Qtd femininos   :"+bar.returnFemininos());
//		System.out.println("CPf 12349678901 :"+bar.clienteCPF("12349678901"));
//		System.out.println("Qtd Socios      :"+bar.getQtdSocios());
//		System.out.println("Qtd Não Socios  :"+bar.getQtdNaoSocios());
		
		
//		clientes.add(cli1);
//		clientes.add(cli2);
//		clientes.add(cli3);
//		
//		
//		System.out.println("Teste");
//		
//		for(int i=0;i<clientes.size();i++){
//			System.out.println("Cliente: "+clientes.get(i));
//		}
			
	}

}
