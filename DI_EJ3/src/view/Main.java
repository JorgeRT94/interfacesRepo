package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerOperations;
import model.Producto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class Main extends JFrame {

	public static List<Producto> listaProductos;
	public static Main main;
	public static int posicion = 1;
	private JPanel contentPane;
	private JTextArea textArea;
	public static JTextField txtFieldCodigo;
	public static JTextField txtFieldNombre;
	public static JTextField txtFieldStockActual;
	public static JTextField txtFieldStockMinimo;
	public static JTextField txtFieldStockMaximo;
	public static JTextField txtFieldPvp;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib/iconProducto.png"));
		
		listaProductos = ControllerOperations.cargarDatos();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				ControllerOperations.guardarProducto();
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCodigo = new JLabel("Codigo: ");

		txtFieldCodigo = new JTextField();
		txtFieldCodigo.setText("" + listaProductos.get(posicion).getCodigo());
		txtFieldCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");

		txtFieldNombre = new JTextField();
		txtFieldNombre.setText("" + listaProductos.get(posicion).getNombre());
		txtFieldNombre.setColumns(10);

		JLabel lblGrupo = new JLabel("Grupo:");

		JRadioButton rdBtnPack = new JRadioButton("Pack");
		buttonGroup.add(rdBtnPack);

		JRadioButton rdBtnUnidad = new JRadioButton("Unidad");
		buttonGroup.add(rdBtnUnidad);

		JRadioButton rdBtnCombinado = new JRadioButton("Combinado");
		buttonGroup.add(rdBtnCombinado);

		ControllerOperations.seleccionRadioButton(listaProductos.get(posicion).getGrupo(), rdBtnPack, rdBtnUnidad,
				rdBtnCombinado);

		JLabel lblComentarios = new JLabel("Comentarios:");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblOtros = new JLabel("Otros:");

		JCheckBox chckBoxFragil = new JCheckBox("es fragil");

		JCheckBox chckBoxObsoleto = new JCheckBox("Obsoleto");

		ControllerOperations.seleccionCheckBox(listaProductos.get(posicion).getOtros(), chckBoxFragil, chckBoxObsoleto);

		JLabel lblStockActual = new JLabel("Stock Actual:");

		txtFieldStockActual = new JTextField();
		txtFieldStockActual.setText("" + listaProductos.get(posicion).getStockActual());
		txtFieldStockActual.setColumns(10);

		txtFieldStockMinimo = new JTextField();
		txtFieldStockMinimo.setText("" + listaProductos.get(posicion).getStockMinimo());
		txtFieldStockMinimo.setColumns(10);

		JLabel lblStockMinimo = new JLabel("Stock Minimo:");

		txtFieldStockMaximo = new JTextField();
		txtFieldStockMaximo.setText("" + listaProductos.get(posicion).getStockMaximo());
		txtFieldStockMaximo.setColumns(10);

		JLabel lblStockMaximo = new JLabel("Stock Maximo:");

		JLabel lblProveedor = new JLabel("Proveedor:");

		JComboBox comboBoxProveedor = new JComboBox();
		comboBoxProveedor.setModel(new DefaultComboBoxModel(new String[] {"Juan", "Pedro", "Sofia"}));

		JLabel lblPvp = new JLabel("PVP:");

		txtFieldPvp = new JTextField();
		txtFieldPvp.setText("" + listaProductos.get(posicion).getPvp());
		txtFieldPvp.setColumns(10);

		JSeparator separator = new JSeparator();

		JButton btnPrimero = new JButton("|<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				posicion = 0;
				ControllerOperations.resetearCheckBoc(chckBoxFragil, chckBoxObsoleto);

				ControllerOperations.actuaizarDatos(posicion, txtFieldCodigo, txtFieldNombre, rdBtnPack, rdBtnUnidad,
						rdBtnCombinado, chckBoxFragil, chckBoxObsoleto, txtFieldStockActual, txtFieldStockMinimo,
						txtFieldStockMaximo, txtFieldPvp, textArea);

			}
		});

		JButton btnAnterior = new JButton("<<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicion > 0) {
					
					posicion--;
					ControllerOperations.resetearCheckBoc(chckBoxFragil, chckBoxObsoleto);
					ControllerOperations.actuaizarDatos(posicion, txtFieldCodigo, txtFieldNombre, rdBtnPack, rdBtnUnidad,
							rdBtnCombinado, chckBoxFragil, chckBoxObsoleto, txtFieldStockActual, txtFieldStockMinimo,
							txtFieldStockMaximo, txtFieldPvp, textArea);
				}
			}
		});

		JButton btnSiguiente = new JButton(">>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (posicion < listaProductos.size() -1) {
					
				posicion++;

				ControllerOperations.resetearCheckBoc(chckBoxFragil, chckBoxObsoleto);

				ControllerOperations.actuaizarDatos(posicion, txtFieldCodigo, txtFieldNombre, rdBtnPack, rdBtnUnidad,
						rdBtnCombinado, chckBoxFragil, chckBoxObsoleto, txtFieldStockActual, txtFieldStockMinimo,
						txtFieldStockMaximo, txtFieldPvp, textArea);
				}
			}
		});

		JButton btnUltimo = new JButton(">|");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				posicion = listaProductos.size() -1;
				ControllerOperations.resetearCheckBoc(chckBoxFragil, chckBoxObsoleto);

				ControllerOperations.actuaizarDatos(posicion, txtFieldCodigo, txtFieldNombre, rdBtnPack, rdBtnUnidad,
						rdBtnCombinado, chckBoxFragil, chckBoxObsoleto, txtFieldStockActual, txtFieldStockMinimo,
						txtFieldStockMaximo, txtFieldPvp, textArea);

			}
		});

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControllerOperations.aniadirProducto();
			}
		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControllerOperations.guardarProducto();
			}
		});

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControllerOperations.borrarProducto();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblNombre)
						.addComponent(lblGrupo)
						.addComponent(lblComentarios)
						.addComponent(lblOtros))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(rdBtnPack)
									.addComponent(rdBtnUnidad)
									.addComponent(rdBtnCombinado)
									.addComponent(txtFieldCodigo, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
								.addComponent(txtFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(76))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckBoxFragil)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckBoxObsoleto)
							.addGap(96)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStockActual)
						.addComponent(lblStockMinimo)
						.addComponent(lblStockMaximo)
						.addComponent(lblProveedor)
						.addComponent(lblPvp))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtFieldPvp, 0, 0, Short.MAX_VALUE)
						.addComponent(txtFieldStockMaximo, 0, 0, Short.MAX_VALUE)
						.addComponent(txtFieldStockMinimo, 0, 0, Short.MAX_VALUE)
						.addComponent(txtFieldStockActual, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
						.addComponent(comboBoxProveedor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnPrimero, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSiguiente, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUltimo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
					.addComponent(btnBorrar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGuardar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNuevo)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStockActual)
						.addComponent(txtFieldStockActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(txtFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGrupo)
								.addComponent(rdBtnPack))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdBtnUnidad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdBtnCombinado)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblComentarios)
								.addComponent(lblProveedor)
								.addComponent(comboBoxProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtFieldStockMinimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStockMinimo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtFieldStockMaximo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStockMaximo))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblOtros)
							.addComponent(chckBoxFragil)
							.addComponent(chckBoxObsoleto))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtFieldPvp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPvp)))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrimero)
						.addComponent(btnAnterior)
						.addComponent(btnSiguiente)
						.addComponent(btnUltimo)
						.addComponent(btnNuevo)
						.addComponent(btnGuardar)
						.addComponent(btnBorrar))
					.addContainerGap())
		);

		textArea = new JTextArea();
		textArea.setText(listaProductos.get(posicion).getComentarios());
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
