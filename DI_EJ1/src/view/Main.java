package view;

import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.LogicFich;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import java.awt.Label;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Main frameMain;
	public int contadorPalabras;
	public static Color colorTexto;
	public static Color colorBackgroundColor;
	public static JTextArea textArea = new JTextArea();
	public String rutaCompleta;

	public Main() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib/thor.png"));
		setTitle("ediTHOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 303);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenu menuArchivo = new JMenu("Archivo");
		mnNewMenu.add(menuArchivo);

		JMenuItem menuItemAbrir = new JMenuItem("Abrir...Ctrl + A");
		menuItemAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog abrirFch = new FileDialog(frameMain, "Abrir archivo", FileDialog.LOAD);
				abrirFch.setVisible(true);
				rutaCompleta = abrirFch.getDirectory() + abrirFch.getFile();
				LogicFich.leerFch(rutaCompleta, textArea);
			}
		});
		menuArchivo.add(menuItemAbrir);

		JMenuItem menuItemGuardarComo = new JMenuItem("Guardar como...Ctrl + G");
		menuItemGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog guardarFchComo = new FileDialog(frameMain, "Guardar archivo como...", FileDialog.SAVE);
				guardarFchComo.setVisible(true);
				rutaCompleta = guardarFchComo.getDirectory() + guardarFchComo.getFile();
				LogicFich.escrbirFch(rutaCompleta, textArea);
			}
		});
		menuArchivo.add(menuItemGuardarComo);

		JMenuItem menuItemGuardar = new JMenuItem("Guardar...Ctrl + S");
		menuItemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rutaCompleta == null) {

					FileDialog guardarFchComo = new FileDialog(frameMain, "Guardar archivo como...", FileDialog.SAVE);
					guardarFchComo.setVisible(true);
					rutaCompleta = guardarFchComo.getDirectory() + guardarFchComo.getFile();
					LogicFich.escrbirFch(rutaCompleta, textArea);
				} else {

					FileDialog guardarFch = new FileDialog(frameMain, "Guardar archivo", FileDialog.SAVE);
					LogicFich.escrbirFch(rutaCompleta, textArea);
				}

			}
		});
		menuArchivo.add(menuItemGuardar);

		JSeparator separator = new JSeparator();
		menuArchivo.add(separator);

		JMenuItem menuItemSalir = new JMenuItem("Salir Ctrl + Q");
		menuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Salir();
			}
		});
		menuArchivo.add(menuItemSalir);

		JMenu menuEstilo = new JMenu("Estilo");
		mnNewMenu.add(menuEstilo);

		JMenuItem menuItemFuente = new JMenuItem("Fuente...");
		menuItemFuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new MenuFuentes();
			}
		});
		menuEstilo.add(menuItemFuente);

		JMenu menuAyuda = new JMenu("Ayuda");
		mnNewMenu.add(menuAyuda);

		JMenuItem menuItemAyuda = new JMenuItem("Ayuda");
		menuItemAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Ayuda();
			}
		});
		menuAyuda.add(menuItemAyuda);

		JMenuItem menuItemAcerca = new JMenuItem("Acerca de...");
		menuItemAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new AcercaDe();
			}
		});
		menuAyuda.add(menuItemAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblCaracteres = new JLabel("Caracteres: ");

		Label lblContCaracteres = new Label("");

		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				textArea.setForeground(colorTexto);
				contadorPalabras++;
				lblContCaracteres.setText("" + contadorPalabras);
			}
		});
		scrollPane.setViewportView(textArea);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblCaracteres).addGap(6)
						.addComponent(lblContCaracteres, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE).addGap(10)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCaracteres, GroupLayout.PREFERRED_SIZE, 14,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContCaracteres, GroupLayout.PREFERRED_SIZE, 14,
												GroupLayout.PREFERRED_SIZE))));
		contentPane.setLayout(gl_contentPane);

		JMenuItem menuItemColores = new JMenuItem("Colores...");
		menuItemColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new MenuColores();
			}
		});
		menuEstilo.add(menuItemColores);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
