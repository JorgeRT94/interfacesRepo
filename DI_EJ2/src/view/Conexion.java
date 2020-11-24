package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbm.DB_MySql;
import dbm.DB_Oracle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txtFieldHost;
	public static JTextField txtFieldPort;
	public static JTextField txtFieldSID;
	public static JTextField txtFieldUser;
	public static JTextField txtFieldPass;
	public static JRadioButton rdBtnOracle;
	public static JRadioButton rdBtnMySql;
	public static String estado;

	public Conexion() {
		setResizable(false);
		setTitle("Conexion");
		setResizable(false);
		setBounds(100, 100, 203, 316);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		rdBtnOracle = new JRadioButton("Oracle");
		rdBtnOracle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdBtnOracle.setSelected(true);
				rdBtnMySql.setSelected(false);
				
			}
		});

		rdBtnMySql = new JRadioButton("MySQL");
		rdBtnMySql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdBtnMySql.setSelected(true);
				rdBtnOracle.setSelected(false);
			}
		});

		JSeparator separator = new JSeparator();

		JLabel lblHost = new JLabel("Host: ");

		txtFieldHost = new JTextField();
		txtFieldHost.setColumns(10);

		txtFieldPort = new JTextField();
		txtFieldPort.setColumns(10);

		txtFieldSID = new JTextField();
		txtFieldSID.setColumns(10);

		JLabel lblPort = new JLabel("Port: ");

		JLabel lblSid = new JLabel("SID: ");

		JSeparator separator_1 = new JSeparator();

		txtFieldUser = new JTextField();
		txtFieldUser.setColumns(10);

		txtFieldPass = new JTextField();
		txtFieldPass.setColumns(10);

		JLabel lblUsuario = new JLabel("User: ");

		JLabel lblContraseña = new JLabel("Pass: ");

		JSeparator separator_2 = new JSeparator();

		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdBtnOracle.isSelected()) {

					DB_Oracle.getConnection();

					if (DB_Oracle.isConected == true) {

						estado = "Estado:		CONECTADO";
						Main.lblEstado.setText("" + estado);
						Main.lblEstado.setForeground(Color.green);

					} else {

						estado = "Estado:  NO CONECTADO. Vuelve a introducir los parametros.";
						Main.lblEstado.setText(estado);
						Main.lblEstado.setForeground(Color.red);
					}

				} else {

					txtFieldSID.setEditable(false);
					DB_MySql.getConnection();
					if (DB_MySql.isConected == true) {

						estado = "Estado:		CONECTADO";
						Main.lblEstado.setText("" + estado);
						Main.lblEstado.setForeground(Color.green);

					} else {

						estado = "Estado:  NO CONECTADO. Vuelve a introducir los parametros.";
						Main.lblEstado.setText(estado);
						Main.lblEstado.setForeground(Color.red);
					}
				}

				dispose();
			}

		});

		JSeparator separator_3 = new JSeparator();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addComponent(rdBtnOracle)
						.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE).addComponent(rdBtnMySql)
						.addGap(24))
				.addGroup(Alignment.LEADING,
						gl_contentPanel.createSequentialGroup()
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblContraseña).addComponent(lblUsuario))
												.addPreferredGap(ComponentPlacement.UNRELATED, 22, Short.MAX_VALUE)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(txtFieldPass).addComponent(txtFieldUser)))
										.addComponent(separator_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 194,
												Short.MAX_VALUE))
								.addGap(11))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 194,
										Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblHost).addComponent(lblPort).addComponent(lblSid))
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtFieldPort, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtFieldSID, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtFieldHost, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(11))
				.addGroup(Alignment.LEADING,
						gl_contentPanel.createSequentialGroup().addGap(15)
								.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(25, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(rdBtnOracle).addComponent(rdBtnMySql))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(
						separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblHost).addComponent(
						txtFieldHost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPort).addComponent(
						txtFieldPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblSid).addComponent(
						txtFieldSID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(separator_3).addComponent(
						separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						txtFieldUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblContraseña).addComponent(txtFieldPass,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnConectar).addGap(30)));
		contentPanel.setLayout(gl_contentPanel);

		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
	}
}
