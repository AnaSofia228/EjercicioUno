package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaOperaciones extends JFrame {
	
	private JPanel PanelPrincipal;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNombre;
	private JButton btnCalcular;
	private JButton btnResultados;
	private JLabel lblPromedio;
	private JLabel lblResultadoProm;
	
	double n1,n2,n3;
    int cantGanan=0, cantpierden=0, cantRecupera=0, cantPierden=0 ,cantEstudiantesValidados=0;
	double prom;
	HashMap<String,Double> notasEstudent = new HashMap<String,Double>();
	

	public VentanaOperaciones() {
		setTitle("Calculo Notas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PanelPrincipal);
		PanelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Promedio de Notas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblTitulo.setBounds(110, 11, 215, 32);
		PanelPrincipal.add(lblTitulo);
		
		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(10, 109, 46, 14);
		PanelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(66, 106, 86, 20);
		PanelPrincipal.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(66, 137, 86, 20);
		PanelPrincipal.add(txtNota2);
		txtNota2.setColumns(10);
		
		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(10, 140, 46, 14);
		PanelPrincipal.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3");
		lblNota3.setBounds(10, 173, 46, 14);
		PanelPrincipal.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setBounds(66, 170, 86, 20);
		PanelPrincipal.add(txtNota3);
		txtNota3.setColumns(10);
		
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Declaracion de variables
				String nombre = (txtNombre.getText());
				
				 
				//Entrada
				
				n1 = Double.parseDouble(txtNota1.getText());
				if (n1<0 || n1>5) {
					JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 5");
				}
				
				n2 = Double.parseDouble(txtNota2.getText());
				if (n2<0 || n2>5) {
					JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 5");
				}
				
				n3 = Double.parseDouble(txtNota3.getText());
				if (n3<0 || n3>5) {
					JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 5");
				}
				
				//proceso
				
				prom = (n1 + n2 + n3) / 3;
				
				//salida de datos
					lblPromedio.setText(""+prom);
				
				//validacion
			      
	            if (prom>=3.5) {
	                lblResultadoProm.setText( "Gana");
	                cantGanan++;
	            }else{
	            	 lblResultadoProm.setText( "Pierde, puede recuperar");
	                cantpierden++;
	            }
	             if ((prom  >= 2) && (prom < 3.5)) {
	            	
	                cantRecupera++;
	            }else if (prom < 2.0) {
	            	lblResultadoProm.setText( "No puede recuperar");
	                cantPierden++;
	         } 
	             //guarda la informacion
	             notasEstudent.put(nombre,prom);
	             cantEstudiantesValidados++;
			}

		});	
		
		btnCalcular.setBounds(256, 227, 89, 23);
		PanelPrincipal.add(btnCalcular);
		
		
		btnResultados = new JButton("Resultados");
		btnResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				imprimirDatos();
				System.out.println("-------------------------------------------------");
				mostrarEstudiantes();
			}

			private void mostrarEstudiantes() {
				
				System.out.println("Lista de estudiantes :");
		        for (String key : notasEstudent.keySet()) {
		            System.out.println("Nombre: "+key + " | "+ "Promedio: " + notasEstudent.get(key));
		        }
				
			}

			private void imprimirDatos() {
				
				System.out.println("Cantidad de estudiantes validados : "+cantEstudiantesValidados);
		        System.out.println("Cantidad de notas ingresadas es : "+cantEstudiantesValidados*3);
		        System.out.println("Cantidad de estudiantes que ganaron: "+cantGanan);
		        System.out.println("Cantidad de estudiantes que perdieron: "+cantpierden);
		        System.out.println("Cantidad de estudiantes que pueden recuperar: "+cantRecupera);
		        System.out.println("Cantidad de estudiantes que perdieron sin recuperacion: "+cantPierden);
				
			}
		});
		btnResultados.setBounds(110, 226, 136, 25);
		PanelPrincipal.add(btnResultados);
		
		
		//cierra el programa
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
							}
		});
		btnSalir.setBounds(31, 227, 69, 23);
		PanelPrincipal.add(btnSalir);
		
		//limpia todo
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				txtNota3.setText("");
				txtNota1.requestFocus();
			}
		});
		btnNuevo.setBounds(355, 227, 69, 23);
		PanelPrincipal.add(btnNuevo);
		
		JLabel lblProm = new JLabel("Promedio Final:");
		lblProm.setHorizontalAlignment(SwingConstants.CENTER);
		lblProm.setBounds(162, 109, 112, 14);
		PanelPrincipal.add(lblProm);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 66, 46, 14);
		PanelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 63, 86, 20);
		PanelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblPromedio = new JLabel("");
		lblPromedio.setBounds(284, 109, 140, 14);
		PanelPrincipal.add(lblPromedio);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(177, 140, 69, 14);
		PanelPrincipal.add(lblResultado);
		
		lblResultadoProm = new JLabel("");
		lblResultadoProm.setBounds(256, 140, 168, 14);
		PanelPrincipal.add(lblResultadoProm);
		
		
	}

}
