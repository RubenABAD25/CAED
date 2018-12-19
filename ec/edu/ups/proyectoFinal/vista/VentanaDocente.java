package ec.edu.ups.proyectoFinal.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.proyectoFinal.entidad.Docente;
import ec.edu.ups.proyectoFinal.logica.Registro;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class VentanaDocente extends JFrame {

	private JPanel contentPane;
	private JTable tblDocente;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtFechaNacimiento;
	private JTextField txtEspecialidad;
	Registro r;
	SimpleDateFormat formato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDocente frame = new VentanaDocente();
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
	public VentanaDocente(){
		iniciarComponentes();
		formato = new SimpleDateFormat( "yyyy-MM-dd");
		r = new Registro();
		
		
	}
	public void iniciarComponentes(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(10, 28, 46, 14);
		panel.add(lblCedula);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 53, 46, 14);
		panel.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 78, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 103, 46, 14);
		panel.add(lblCorreo);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(270, 28, 109, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setBounds(270, 53, 109, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(270, 78, 109, 14);
		panel.add(lblFechaDeNacimiento);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(270, 103, 109, 14);
		panel.add(lblEspecialidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 561, 130);
		panel.add(scrollPane);
		
		tblDocente = new JTable();
		tblDocente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula","Apellido","Nombre","Correo","Direccion","Telefono","Fecha de Nacimiento","Especialidad"
			}
		));
		scrollPane.setViewportView(tblDocente);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(80, 25, 180, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(389, 25, 176, 20);
		panel.add(txtDireccion);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(80, 50, 180, 20);
		panel.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(80, 78, 180, 20);
		panel.add(txtNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(80, 100, 180, 20);
		panel.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(389, 50, 176, 20);
		panel.add(txtTelefono);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(389, 75, 176, 20);
		panel.add(txtFechaNacimiento);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(389, 103, 176, 20);
		panel.add(txtEspecialidad);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//formato de la fecha yyy-mm-dd
					Docente d = new Docente(txtCedula.getText(),txtApellido.getText(), txtNombre.getText(),
							txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(),
							formato.parse(txtFechaNacimiento.getText()), txtEspecialidad.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnGuardar.setBounds(104, 147, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnListar.setBounds(244, 147, 89, 23);
		panel.add(btnListar);
	}
	public boolean llenarTabla(){
		boolean retorno=false;
		
		return retorno;
	}
	
}
