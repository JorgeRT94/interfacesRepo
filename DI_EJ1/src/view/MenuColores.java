package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuColores extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static Color colorTxt;
	public static Color colorFondo;
	private JLabel lblColorTexto;
	private JButton btnNegroTexto;
	private JButton btnRojoTexto;
	private JButton btnVerdeTexto;
	private JButton btnAzulTexto;
	private JButton btnBlancoTexto;
	private JButton btnNaranjaTexto;
	private JButton btnAmarilloTexto;
	private JButton btnCelesteTexto;
	public JButton btnOk;
	private JButton btnNegroFondo;
	private JButton btnRojoFondo;
	private JButton btnVerdeFondo;
	private JButton btnAzulFondo;
	private JButton btnBlancoFondo;
	private JButton btnNaranjaFondo;
	private JButton btnAmarilloFondo;
	private JButton btnCelesteFondo;
	private JLabel lblEjemplo;
	private JButton btnCancelar;

	public MenuColores() {
		setTitle("Color");

		setBounds(100, 100, 422, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblColorTexto = new JLabel("Fuente");
			lblColorTexto.setBounds(15, 16, 64, 14);
		}
		{
			btnNegroTexto = new JButton("*");
			btnNegroTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					colorTxt = Color.black;
					lblEjemplo.setForeground(Color.black);
				}
			});
			btnNegroTexto.setBounds(15, 36, 36, 36);
			btnNegroTexto.setForeground(Color.BLACK);
			btnNegroTexto.setBackground(Color.BLACK);
		}
		{
			btnRojoTexto = new JButton("*");
			btnRojoTexto.setForeground(Color.RED);
			btnRojoTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					colorTxt = Color.red;
					lblEjemplo.setForeground(Color.red);

				}
			});
			btnRojoTexto.setBounds(57, 36, 36, 36);
			btnRojoTexto.setBackground(Color.RED);
		}
		{
			btnVerdeTexto = new JButton("*");
			btnVerdeTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorTxt = Color.green;
					lblEjemplo.setForeground(Color.green);
				}
			});
			btnVerdeTexto.setForeground(Color.GREEN);
			btnVerdeTexto.setBounds(100, 36, 36, 36);
			btnVerdeTexto.setBackground(Color.GREEN);
		}
		contentPanel.setLayout(null);
		contentPanel.add(lblColorTexto);

		JLabel lblColorFondo = new JLabel("Fondo");
		lblColorFondo.setBounds(234, 15, 61, 16);
		contentPanel.add(lblColorFondo);
		contentPanel.add(btnNegroTexto);
		{
			btnAzulTexto = new JButton("*");
			btnAzulTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorTxt = Color.blue;
					lblEjemplo.setForeground(Color.blue);
				}
			});
			btnAzulTexto.setForeground(Color.BLUE);
			btnAzulTexto.setBackground(Color.BLUE);
			btnAzulTexto.setBounds(146, 36, 36, 36);
			contentPanel.add(btnAzulTexto);
		}
		contentPanel.add(btnRojoTexto);
		{
			btnBlancoTexto = new JButton("*");
			btnBlancoTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorTxt = Color.white;
					lblEjemplo.setForeground(Color.white);
				}
			});
			btnBlancoTexto.setForeground(Color.LIGHT_GRAY);
			btnBlancoTexto.setBackground(Color.WHITE);
			btnBlancoTexto.setBounds(15, 77, 36, 36);
			contentPanel.add(btnBlancoTexto);
		}
		{
			btnNaranjaTexto = new JButton("*");
			btnNaranjaTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorTxt = Color.orange;
					lblEjemplo.setForeground(Color.orange);
				}
			});
			btnNaranjaTexto.setForeground(Color.ORANGE);
			btnNaranjaTexto.setBackground(Color.ORANGE);
			btnNaranjaTexto.setBounds(57, 78, 36, 36);
			contentPanel.add(btnNaranjaTexto);
		}
		{
			btnAmarilloTexto = new JButton("*");
			btnAmarilloTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorTxt = Color.yellow;
					lblEjemplo.setForeground(Color.yellow);
				}
			});
			btnAmarilloTexto.setForeground(Color.YELLOW);
			btnAmarilloTexto.setBackground(Color.YELLOW);
			btnAmarilloTexto.setBounds(100, 78, 36, 36);
			contentPanel.add(btnAmarilloTexto);
		}
		{
			btnCelesteTexto = new JButton("*");
			btnCelesteTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorTxt = Color.cyan;
					lblEjemplo.setForeground(Color.cyan);
				}
			});
			btnCelesteTexto.setForeground(Color.CYAN);
			btnCelesteTexto.setBackground(Color.CYAN);
			btnCelesteTexto.setBounds(146, 78, 36, 36);
			contentPanel.add(btnCelesteTexto);
		}
		contentPanel.add(btnVerdeTexto);
		{
			btnNegroFondo = new JButton("*");
			btnNegroFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.black;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnNegroFondo.setForeground(Color.BLACK);
			btnNegroFondo.setBackground(Color.BLACK);
			btnNegroFondo.setBounds(234, 36, 36, 36);
			contentPanel.add(btnNegroFondo);
		}
		{
			btnRojoFondo = new JButton("*");
			btnRojoFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.red;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnRojoFondo.setForeground(Color.RED);
			btnRojoFondo.setBackground(Color.RED);
			btnRojoFondo.setBounds(282, 36, 36, 36);
			contentPanel.add(btnRojoFondo);
		}
		{
			btnVerdeFondo = new JButton("*");
			btnVerdeFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.green;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnVerdeFondo.setForeground(Color.GREEN);
			btnVerdeFondo.setBackground(Color.GREEN);
			btnVerdeFondo.setBounds(330, 36, 36, 36);
			contentPanel.add(btnVerdeFondo);
		}
		{
			btnAzulFondo = new JButton("*");
			btnAzulFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.blue;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnAzulFondo.setForeground(Color.BLUE);
			btnAzulFondo.setBackground(Color.BLUE);
			btnAzulFondo.setBounds(378, 36, 36, 36);
			contentPanel.add(btnAzulFondo);
		}
		{
			btnBlancoFondo = new JButton("*");
			btnBlancoFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.white;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnBlancoFondo.setForeground(Color.LIGHT_GRAY);
			btnBlancoFondo.setBackground(Color.WHITE);
			btnBlancoFondo.setBounds(234, 77, 36, 36);
			contentPanel.add(btnBlancoFondo);
		}
		{
			btnNaranjaFondo = new JButton("*");
			btnNaranjaFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.orange;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnNaranjaFondo.setForeground(Color.ORANGE);
			btnNaranjaFondo.setBackground(Color.ORANGE);
			btnNaranjaFondo.setBounds(282, 77, 36, 36);
			contentPanel.add(btnNaranjaFondo);
		}
		{
			btnAmarilloFondo = new JButton("*");
			btnAmarilloFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.yellow;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnAmarilloFondo.setForeground(Color.YELLOW);
			btnAmarilloFondo.setBackground(Color.YELLOW);
			btnAmarilloFondo.setBounds(330, 77, 36, 36);
			contentPanel.add(btnAmarilloFondo);
		}
		{
			btnCelesteFondo = new JButton("*");
			btnCelesteFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					colorFondo = Color.cyan;
					lblEjemplo.setOpaque(true);
					lblEjemplo.setBackground(colorFondo);
				}
			});
			btnCelesteFondo.setForeground(Color.CYAN);
			btnCelesteFondo.setBackground(Color.CYAN);
			btnCelesteFondo.setBounds(378, 77, 36, 36);
			contentPanel.add(btnCelesteFondo);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Main.colorTexto = colorTxt;
						Main.textArea.setForeground(colorTxt);
						Main.textArea.setBackground(colorFondo);
						dispose();
					}
				});
				{
					lblEjemplo = new JLabel("EJEMPLO");
					lblEjemplo.setBackground(Color.WHITE);
					lblEjemplo.setHorizontalAlignment(SwingConstants.LEFT);
				}
				btnOk.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(59).addComponent(lblEjemplo).addGap(139)
							.addComponent(btnOk).addGap(5).addComponent(btnCancelar)));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(5)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE).addComponent(btnOk)
									.addComponent(lblEjemplo)))
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(5).addComponent(btnCancelar)));
			buttonPane.setLayout(gl_buttonPane);

		}
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

}