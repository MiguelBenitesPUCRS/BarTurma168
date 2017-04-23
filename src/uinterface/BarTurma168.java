package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Bar;
import business.Cliente;
import business.Socio;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
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

public class BarTurma168 extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textCpf;
	private JTextField textSocio;
	private JTextField textField;
	private JTextField textField_1;
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
		setBounds(100, 100, 744, 520);
		setLocationRelativeTo(null); //centraliza a janela
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblNScio = new JLabel("N.\u00BA S\u00F3cio:");
		lblNScio.setBounds(10, 179, 55, 14);
		contentPane.add(lblNScio);
		
		textNome = new JTextField();
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String fMaiuscula = textNome.getText();
				fMaiuscula = fMaiuscula.substring(0,1).toUpperCase().concat(fMaiuscula.substring(1));
				textNome.setText(fMaiuscula);
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
		
		JLabel lblClientesNoBar = new JLabel("Clientes no bar:");
		lblClientesNoBar.setIcon(new ImageIcon(getClass().getResource("/icons/People.png")));
		
		//lblClientesNoBar.setIcon(new ImageIcon("C:\\Users\\F\u00E1bio\\Downloads\\16x16-free-application-icons\\16x16-free-application-icons\\png\\16x16\\People.png"));
		lblClientesNoBar.setBounds(360, 27, 137, 16);
		contentPane.add(lblClientesNoBar);
		
		JLabel lblTotalClientes = new JLabel("0");
		lblTotalClientes.setBounds(508, 27, 46, 14);
		contentPane.add(lblTotalClientes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 426, 698, 2);
		contentPane.add(separator);
		
		JLabel lblMulheres = new JLabel("% Mulheres:");
		lblMulheres.setIcon(new ImageIcon(getClass().getResource("/icons/Female.png")));
		lblMulheres.setBounds(10, 360, 102, 16);
		contentPane.add(lblMulheres);
		
		JLabel lblHomens = new JLabel("% Homens:");
		lblHomens.setIcon(new ImageIcon(getClass().getResource("/icons/Male.png")));
		lblHomens.setBounds(10, 385, 85, 16);
		contentPane.add(lblHomens);
		
		JLabel lblPercFem = new JLabel();
		lblPercFem.setText("%");
		lblPercFem.setBounds(105, 360, 46, 14);
		contentPane.add(lblPercFem);
		
		JLabel lblPercMasc = new JLabel("%");
		lblPercMasc.setBounds(105, 385, 46, 14);
		contentPane.add(lblPercMasc);
		
		JLabel lblSocios = new JLabel("S\u00F3cios:");
		lblSocios.setIcon(new ImageIcon(getClass().getResource("/icons/Favourites.png")));
		lblSocios.setBounds(178, 385, 86, 16);
		contentPane.add(lblSocios);
		
		JLabel lblQtdSocios = new JLabel("0");
		lblQtdSocios.setBounds(289, 387, 46, 14);
		contentPane.add(lblQtdSocios);
		
		JLabel lblNoScios = new JLabel("N\u00E3o S\u00F3cios:");
		lblNoScios.setIcon(new ImageIcon(getClass().getResource("/icons/Person.png")));
		lblNoScios.setBounds(179, 360, 100, 16);
		contentPane.add(lblNoScios);
		
		JLabel lblQtdNaoSocios = new JLabel("0");
		lblQtdNaoSocios.setBounds(289, 362, 46, 14);
		contentPane.add(lblQtdNaoSocios);
		
		
		
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
					model.addElement(cli.get(i).getNome());
				}
				
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
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(getClass().getResource("/icons/Exit.png")));
		btnSair.setBounds(597, 438, 111, 32);
		contentPane.add(btnSair);
		
		JLabel lblConsultar = new JLabel("Consultar CPF:");
		lblConsultar.setIcon(new ImageIcon(getClass().getResource("/icons/Zoom.png")));
		lblConsultar.setBounds(10, 277, 156, 14);
		contentPane.add(lblConsultar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(150, 274, 200, 20);
		contentPane.add(textField);
		
		JLabel lblRemoverCliente = new JLabel("Remover cliente informe CPF:");
		lblRemoverCliente.setIcon(new ImageIcon(getClass().getResource("/icons/No-entry.png")));
		lblRemoverCliente.setBounds(360, 385, 232, 30);
		contentPane.add(lblRemoverCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(571, 382, 137, 20);
		contentPane.add(textField_1);
		
		JButton btnConsultar = new JButton("Consultar...");
		btnConsultar.setBounds(150, 302, 119, 23);
		contentPane.add(btnConsultar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textNome, textIdade, textCpf, cmbSexo, chckbxScio, textSocio, btnAdicionar}));
	}
}
