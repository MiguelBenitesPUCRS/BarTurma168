package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Bar;
import business.Cliente;
import business.Socio;
import persistence.Arquivo;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

public class BarTurma168 extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textCpf;
	private JTextField textSocio;
	private JTextField textConsultar;
	private JTextField textRemoveCPF;
	private DefaultListModel model = new DefaultListModel();
	
	Bar bar = new Bar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarTurma168 frame = new BarTurma168();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BarTurma168() {
		setTitle("Bar Turma 168");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 543);
		setLocationRelativeTo(null); //centraliza a janela
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Labels....
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 53, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 78, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 103, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 128, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblNScio = new JLabel("N.\u00BA S\u00F3cio:");
		lblNScio.setBounds(10, 179, 55, 14);
		contentPane.add(lblNScio);
		
		JLabel lblClientesNoBar = new JLabel("Clientes no bar:");
		lblClientesNoBar.setIcon(new ImageIcon(getClass().getResource("/icons/People.png")));
		
		lblClientesNoBar.setBounds(360, 27, 137, 16);
		contentPane.add(lblClientesNoBar);
		
		JLabel lblTotalClientes = new JLabel("0");
		lblTotalClientes.setBounds(508, 27, 46, 14);
		contentPane.add(lblTotalClientes);
		
		JLabel lblMulheres = new JLabel("% Mulheres:");
		lblMulheres.setIcon(new ImageIcon(getClass().getResource("/icons/Female.png")));
		lblMulheres.setBounds(10, 396, 102, 16);
		contentPane.add(lblMulheres);
		
		JLabel lblHomens = new JLabel("% Homens:");
		lblHomens.setIcon(new ImageIcon(getClass().getResource("/icons/Male.png")));
		lblHomens.setBounds(10, 421, 85, 16);
		contentPane.add(lblHomens);
		
		JLabel lblPercFem = new JLabel();
		lblPercFem.setText("%");
		lblPercFem.setBounds(105, 396, 46, 14);
		contentPane.add(lblPercFem);
		
		JLabel lblPercMasc = new JLabel("%");
		lblPercMasc.setBounds(105, 421, 46, 14);
		contentPane.add(lblPercMasc);
		
		JLabel lblSocios = new JLabel("S\u00F3cios:");
		lblSocios.setIcon(new ImageIcon(getClass().getResource("/icons/Favourites.png")));
		lblSocios.setBounds(178, 421, 86, 16);
		contentPane.add(lblSocios);
		
		JLabel lblQtdSocios = new JLabel("0");
		lblQtdSocios.setBounds(289, 423, 46, 14);
		contentPane.add(lblQtdSocios);
		
		JLabel lblNoScios = new JLabel("N\u00E3o S\u00F3cios:");
		lblNoScios.setIcon(new ImageIcon(getClass().getResource("/icons/Person.png")));
		lblNoScios.setBounds(179, 396, 100, 16);
		contentPane.add(lblNoScios);
		
		JLabel lblQtdNaoSocios = new JLabel("0");
		lblQtdNaoSocios.setBounds(289, 398, 46, 14);
		contentPane.add(lblQtdNaoSocios);
		
		JLabel lblConsultar = new JLabel("Consultar CPF:");
		lblConsultar.setIcon(new ImageIcon(getClass().getResource("/icons/Zoom.png")));
		lblConsultar.setBounds(10, 277, 156, 14);
		contentPane.add(lblConsultar);
		
		JLabel lblRemoverCliente = new JLabel("Remover cliente informe CPF:");
		lblRemoverCliente.setIcon(new ImageIcon(getClass().getResource("/icons/No-entry.png")));
		lblRemoverCliente.setBounds(370, 371, 232, 30);
		contentPane.add(lblRemoverCliente);
		
		//Checkbox de sócio
		JCheckBox chckbxScio = new JCheckBox("S\u00F3cio");
		chckbxScio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxScio.isEnabled()){
					textSocio.setEnabled(true);
				} else {
					textSocio.setEnabled(false);
				}
			}
		});
		chckbxScio.setBounds(80, 152, 97, 23);
		contentPane.add(chckbxScio);
		
		
		//Textbox do Nome, primeira letra em maiúscula...
		textNome = new JTextField();
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!textNome.getText().equals("")){
					String fMaiuscula = textNome.getText();
					fMaiuscula = fMaiuscula.substring(0,1).toUpperCase().concat(fMaiuscula.substring(1));
					textNome.setText(fMaiuscula);
				}
			}
		});
		textNome.setBounds(80, 50, 270, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setBounds(80, 75, 86, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(80, 100, 177, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cmbSexo.setBounds(80, 125, 86, 20);
		contentPane.add(cmbSexo);
		
		textSocio = new JTextField();
		textSocio.setEnabled(false);
		textSocio.setBounds(80, 176, 177, 20);
		contentPane.add(textSocio);
		textSocio.setColumns(10);
		
		JList list = new JList(model);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(360, 52, 348, 319);
		contentPane.add(list);
		
		
		//Separador...
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 448, 698, 2);
		contentPane.add(separator); 
		
		
		//Botão de adicionar no list e no bar
		JButton btnAdicionar = new JButton("Adicionar >>");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				Cliente cliente;
				String sNome;
				String sCPF;
				int iIdade;
				char cGenero;
				String sNumSocio;
				ArrayList<Cliente> cli;
				
				sNome = textNome.getText();
				sCPF = textCpf.getText();
				iIdade = Integer.parseInt(textIdade.getText());
				
				if(cmbSexo.getSelectedIndex()==0){
					cGenero = 'M';
				} else {
					cGenero = 'F';
				}
				
				sNumSocio = textSocio.getText();
			
				//combobox de clientes
				if(chckbxScio.isSelected()){
					cliente = new Socio(sNome, sCPF, iIdade, cGenero, sNumSocio);
				} else {
					cliente = new Cliente(sNome, sCPF, iIdade, cGenero);
				} 
				
				bar.addCliente(cliente);				
				model.clear();
				cli = bar.getClientes();
				
				for(int i=0;i<cli.size();i++){
					if(cli.get(i).isNoBar()==true){
						model.addElement(cli.get(i).getNome());
					}
				}		
				
				textNome.setText("");
				textCpf.setText("");
				textIdade.setText("");
				
				textSocio.setText("");
				textSocio.setEnabled(false);
				chckbxScio.setSelected(false);

				lblTotalClientes.setText(Integer.toString(bar.getQtdClientes()));
				lblPercFem.setText(Integer.toString(bar.getPercentualFeminino())+"%");
				lblPercMasc.setText(Integer.toString(bar.getPercentualMasculino())+"%");
				lblQtdSocios.setText(Integer.toString(bar.getQtdSocios()));
				lblQtdNaoSocios.setText(Integer.toString(bar.getQtdNaoSocios()));			
			
			}
		});
		btnAdicionar.setBounds(80, 208, 119, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sai do sistema
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(getClass().getResource("/icons/Exit.png")));
		btnSair.setBounds(597, 461, 111, 32);
		contentPane.add(btnSair);
		
		
		textConsultar = new JTextField();
		textConsultar.setColumns(10);
		textConsultar.setBounds(150, 274, 200, 20);
		contentPane.add(textConsultar);
		
		textRemoveCPF = new JTextField();
		textRemoveCPF.setColumns(10);
		textRemoveCPF.setBounds(576, 382, 132, 20);
		contentPane.add(textRemoveCPF);
		
		//Botão de consulta..
		JButton btnConsultar = new JButton("Consultar...");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//implementar o botão de consultar...
				if(!textConsultar.getText().equals("")){
					String cpf = textConsultar.getText();
					Cliente cliente = bar.consultaCliente(cpf);
					if (cliente == null){
						JOptionPane.showMessageDialog(null, "Cliente NÃO encontrado!", "Consulta", JOptionPane.WARNING_MESSAGE);
					} else {
						String sNome;
						String sCPF;
						String iIdade;
						String sCliente;
						sNome = cliente.getNome();
						sCPF = cliente.getCPF();
						iIdade = Integer.toString(cliente.getIdade());
						sCliente = "Nome: "+sNome+"\nCPF: "+sCPF+"\nIdade: "+iIdade;		
						JOptionPane.showMessageDialog(null, "Cliente encontrado!\n"+ sCliente);				
					}
				}
			}
		});
		btnConsultar.setBounds(150, 302, 119, 23);
		contentPane.add(btnConsultar);
		
		
		//Botão remover...
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textRemoveCPF.getText().equals("")){
					String cpf = textRemoveCPF.getText();
					Cliente cliente = bar.consultaCliente(cpf);
					if (cliente == null){
						JOptionPane.showMessageDialog(null, "Cliente NÃO encontrado!", "Remover", JOptionPane.WARNING_MESSAGE);
					} else {
						String sNome;
						String sCPF;
						sNome = cliente.getNome();
						sCPF = cliente.getCPF();
						ArrayList<Cliente> cli;
						
						bar.removeCliente(cpf);
						
						model.clear();
						cli = bar.getClientes();
						
						for(int i=0;i<cli.size();i++){
							if(cli.get(i).isNoBar()==true){
								model.addElement(cli.get(i).getNome());
							}
						}
				
						lblTotalClientes.setText(Integer.toString(bar.getQtdClientes()));
						lblPercFem.setText(Integer.toString(bar.getPercentualFeminino())+"%");
						lblPercMasc.setText(Integer.toString(bar.getPercentualMasculino())+"%");
						lblQtdSocios.setText(Integer.toString(bar.getQtdSocios()));
						lblQtdNaoSocios.setText(Integer.toString(bar.getQtdNaoSocios()));

						JOptionPane.showMessageDialog(null, "Cliente "+sNome+ " removido");				
					}
				}
			}
		});
		btnRemover.setBounds(576, 413, 132, 23);
		contentPane.add(btnRemover);
		
		JLabel lblEstatsticas = new JLabel("Estat\u00EDsticas:");
		lblEstatsticas.setBounds(10, 371, 102, 14);
		contentPane.add(lblEstatsticas);
		
		JButton btnArquivo = new JButton("Arquivo");
		btnArquivo.setIcon(null);
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arquivo arq = new Arquivo();
				ArrayList<Cliente> clientes = bar.getClientes();
				
				
				for(int i=0;i<clientes.size();i++){
					try {
						arq.grava("clientes.txt", clientes.get(i).getNome());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");	
			}
		});
		btnArquivo.setIcon(new ImageIcon(getClass().getResource("/icons/List.png")));
		btnArquivo.setBounds(476, 461, 111, 32);
		contentPane.add(btnArquivo);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textNome, textIdade, textCpf, cmbSexo, chckbxScio, textSocio, btnAdicionar}));
		
		
	}
	

}
