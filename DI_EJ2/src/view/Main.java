package view;

import java.awt.FileDialog;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerOperations;
import dbm.DB_Oracle;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextArea textAreaResultado;
	private JTextArea textAreaConsulta;
	public static JLabel lblEstado;
	public static Main frame;
	public static String rutaCompleta;

	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib/icon.png"));
		setTitle("Consultas SQL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 407);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		JMenuItem menuItemConexion = new JMenuItem("Conexion...");
		menuItemConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Conexion();
			}
		});
		menuArchivo.add(menuItemConexion);

		JMenu menuConsulta = new JMenu("Consulta");
		menuArchivo.add(menuConsulta);

		JMenuItem menuiItemCargar = new JMenuItem("Cargar");
		menuiItemCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog abrirConsulta = new FileDialog(frame, "Abrir consulta", FileDialog.LOAD);
				abrirConsulta.setVisible(true);

				rutaCompleta = abrirConsulta.getDirectory() + abrirConsulta.getFile();
				ControllerOperations.cargarConsulta(rutaCompleta, textAreaConsulta);
			}
		});
		menuConsulta.add(menuiItemCargar);

		JMenuItem menuItemLimpiar = new JMenuItem("Limpiar");
		menuItemLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaConsulta.setText("");
			}
		});
		menuConsulta.add(menuItemLimpiar);

		JMenu menuResultados = new JMenu("Resultados");
		menuArchivo.add(menuResultados);

		JMenuItem menuItemGuardar = new JMenuItem("Guardar...");
		menuItemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog guardarFchComo = new FileDialog(frame, "Guardar archivo como...", FileDialog.SAVE);
				guardarFchComo.setVisible(true);
				rutaCompleta = guardarFchComo.getDirectory() + guardarFchComo.getFile();
				ControllerOperations.guardarConsulta(rutaCompleta, textAreaConsulta, textAreaResultado);
			}
		});
		menuResultados.add(menuItemGuardar);

		JMenuItem menuItemLimpiarRes = new JMenuItem("Limpiar");
		menuItemLimpiarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaResultado.setText("");
			}
		});
		menuResultados.add(menuItemLimpiarRes);

		JSeparator separator = new JSeparator();
		menuArchivo.add(separator);

		JMenuItem menuItemSalir = new JMenuItem("Salir Ctrl + Q");
		menuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Salir();
			}
		});
		menuArchivo.add(menuItemSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textAreaConsulta = new JTextArea();
		textAreaConsulta.setBackground(Color.WHITE);
		scrollPane.setViewportView(textAreaConsulta);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBackground(Color.DARK_GRAY);

		textAreaResultado = new JTextArea();
		textAreaResultado.setBackground(Color.DARK_GRAY);
		textAreaResultado.setForeground(Color.white);
		scrollPane_1.setViewportView(textAreaResultado);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAreaConsulta.setText("");
				textAreaResultado.setText("");
			}
		});

		JButton btnEjecutar = new JButton("EJECUTAR");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String consultaSQL = textAreaConsulta.getText();
				ControllerOperations.mostrarConsulta(DB_Oracle.getConnection(), consultaSQL, textAreaResultado);

			}
		});

		lblEstado = new JLabel("Estado: ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE).addGap(3)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE).addGap(12)
						.addComponent(btnEjecutar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGap(90).addComponent(lblEstado).addContainerGap(233, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnLimpiar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane
										.createParallelGroup(Alignment.BASELINE).addComponent(btnEjecutar,
												GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEstado)))));
		contentPane.setLayout(gl_contentPane);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
