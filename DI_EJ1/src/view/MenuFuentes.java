package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFuentes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	Dimension dimension = new Dimension();
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblEjemplo;
	public static String nombreFuente;
	public static int tamanioFuente = 15;
	public static int estiloFuente;
	public static Font font;

	public MenuFuentes() {
		setTitle("Fuentes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblFuente = new JLabel("Fuente");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblEstilo = new JLabel("Estilo");

		JCheckBox chckBoxNormal = new JCheckBox("Normal");
		JCheckBox chckBoxNegrita = new JCheckBox("Negrita");
		JCheckBox chckBoxCursiva = new JCheckBox("Cursiva");
		JCheckBox chckBoxSubrayada = new JCheckBox("Subrayada");

		chckBoxNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckBoxNormal.isSelected()) {

					chckBoxCursiva.setSelected(false);
					chckBoxNegrita.setSelected(false);
					chckBoxSubrayada.setSelected(false);

					estiloFuente = Font.PLAIN;
					lblEjemplo.setFont(
							new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));

				} else {
					estiloFuente = 0;
					lblEjemplo.setFont(
							new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));
				}

			}
		});

		chckBoxNegrita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckBoxNegrita.isSelected()) {

					estiloFuente = Font.BOLD;
					lblEjemplo.setFont(
							new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));
					chckBoxNormal.setSelected(false);
					if (chckBoxCursiva.isSelected()) {

						estiloFuente = Font.BOLD + Font.ITALIC;
						lblEjemplo.setFont(
								new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));

					}

				} else {
					estiloFuente = 0;
					lblEjemplo.setFont(
							new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));
				}

			}
		});

		chckBoxCursiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckBoxCursiva.isSelected()) {

					estiloFuente = Font.ITALIC;
					lblEjemplo.setFont(
							new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));

					if (chckBoxNegrita.isSelected()) {

						estiloFuente = Font.ITALIC + Font.BOLD;
						lblEjemplo.setFont(
								new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));

					} else if (chckBoxNormal.isSelected()) {

						chckBoxNegrita.setSelected(false);
						estiloFuente = Font.PLAIN + Font.ITALIC;
						lblEjemplo.setFont(
								new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));

					}

				} else {
					estiloFuente = 0;
					lblEjemplo.setFont(
							new Font(lblEjemplo.getFont().getName(), estiloFuente, lblEjemplo.getFont().getSize()));
				}

			}
		});

		JLabel lblTamanio = new JLabel("Tamaño");

		JSpinner spTamanio = new JSpinner();
		spTamanio.setModel(new SpinnerNumberModel(15, 1, 20, 1));
		spTamanio.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				tamanioFuente = (int) spTamanio.getValue();
				lblEjemplo.setFont(
						new Font(lblEjemplo.getFont().getName(), lblEjemplo.getFont().getStyle(), tamanioFuente));
			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblFuente)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGap(47)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblEstilo)
								.addComponent(chckBoxNormal).addComponent(chckBoxNegrita).addComponent(chckBoxCursiva)
								.addComponent(chckBoxSubrayada))
						.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblTamanio)
								.addComponent(spTamanio, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(26, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(20)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFuente)
						.addComponent(lblEstilo).addComponent(lblTamanio))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(chckBoxNormal).addComponent(spTamanio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckBoxNegrita)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckBoxCursiva)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckBoxSubrayada))
						.addComponent(scrollPane))
				.addContainerGap(82, Short.MAX_VALUE)));

		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				nombreFuente = (String) list.getSelectedValue();
				lblEjemplo.setFont(new Font(nombreFuente, lblEjemplo.getFont().getStyle(), tamanioFuente));
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Arial", "Courier", "Comic Sans" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		scrollPane.setRowHeaderView(list);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						font = new Font(nombreFuente, estiloFuente, tamanioFuente);
						Main.textArea.setFont(font);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}

			lblEjemplo = new JLabel("EJEMPLO");
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addContainerGap().addComponent(lblEjemplo)
							.addGap(212).addComponent(okButton).addGap(5).addComponent(cancelButton)));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(5)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
											.addComponent(okButton).addComponent(lblEjemplo))
									.addComponent(cancelButton))));
			buttonPane.setLayout(gl_buttonPane);
		}

		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
	}
}
