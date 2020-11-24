package controller;

import lib.LibFrontend;
import logic.LogicOperations;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Producto;
import view.Main;

public class ControllerOperations {

	public static String nombreFichero = "lib/fichero.data";

	public static int codigo = 0;

	public static List<Producto> llenarListaProductos() {

		Producto vaso = new Producto(codigo++, 2, 1, 100, 1, 200, "", (float) 62.2, "Vaso",
				"Cristal de Bangladesh autentico.");
		Producto plato = new Producto(codigo++, 1, 1, 100, 1, 200, "", (float) 29.50, "Plato",
				"Plato hecho con cerámica de Marruecos.");
		Producto tenedor = new Producto(codigo++, 1, 2, 100, 1, 200, "", (float) 1.20, "Tenedor",
				"Hecho con acero inoxidable.");

		List<Producto> listProductos = new ArrayList<Producto>();

		listProductos.add(vaso);
		listProductos.add(plato);
		listProductos.add(tenedor);

		return listProductos;
	}

	public static void seleccionRadioButton(int seleccion, JRadioButton rdBtnPack, JRadioButton rdBtnUnidad,
			JRadioButton rdBtnCombinado) {

		if (seleccion == 1) {
			rdBtnPack.setSelected(true);
			rdBtnUnidad.setSelected(false);
			rdBtnCombinado.setSelected(false);
		} else if (seleccion == 2) {
			rdBtnPack.setSelected(false);
			rdBtnUnidad.setSelected(true);
			rdBtnCombinado.setSelected(false);
		} else {
			rdBtnPack.setSelected(false);
			rdBtnUnidad.setSelected(false);
			rdBtnCombinado.setSelected(true);
		}

	}

	public static void seleccionCheckBox(int seleccion, JCheckBox c, JCheckBox c1) {

		if (seleccion == 1) {
			c.setSelected(true);
		} else if (seleccion == 2) {
			c1.setSelected(true);
		} else if (seleccion == 1 && seleccion == 2) {
			c.setSelected(true);
			c1.setSelected(true);
		} else {
			c.setSelected(false);
			c1.setSelected(false);
		}

	}

	public static void resetearCheckBoc(JCheckBox c, JCheckBox c1) {

		if (c.isSelected()) {
			c.setSelected(false);
		} else if (c1.isSelected()) {
			c1.setSelected(false);
		}
	}

	public static void seleccionProveedor() {

	}

	public static void actuaizarDatos(int posicion, JTextField tf, JTextField tf1, JRadioButton rdB, JRadioButton rdB1,
			JRadioButton rdB2, JCheckBox c1, JCheckBox c2, JTextField tf2, JTextField tf3, JTextField tf4,
			JTextField tf5, JTextArea textArea) {

		resetearCheckBoc(c1, c2);
		tf.setText("" + Main.listaProductos.get(posicion).getCodigo());
		tf1.setText("" + Main.listaProductos.get(posicion).getNombre());
		seleccionRadioButton(Main.listaProductos.get(posicion).getGrupo(), rdB, rdB1, rdB2);
		seleccionCheckBox(Main.listaProductos.get(posicion).getOtros(), c1, c2);
		tf2.setText("" + Main.listaProductos.get(posicion).getStockActual());
		tf3.setText("" + Main.listaProductos.get(posicion).getStockMinimo());
		tf4.setText("" + Main.listaProductos.get(posicion).getStockMaximo());
		tf5.setText("" + Main.listaProductos.get(posicion).getPvp());
		textArea.setText(Main.listaProductos.get(posicion).getComentarios());

	}

	public static void aniadirProducto() {

		int codigoProducto = codigo++;
		int grupo = LibFrontend.validaNumero("¿A que grupo pertenece el producto?\n1.Pack 2.Unidad 3. Combinado", 1, 3);
		int otros = LibFrontend.validaNumero("¿Es fragil?\n1. Si 2. No", 1, 2);
		int stockActual = LibFrontend.validaNumero("De cuanto stock dispones: ", 0, 200);
		int stockMinimo = LibFrontend.validaNumero("¿Cual es el stock minimo del producto? ", 0, 200);
		int stockMaximo = LibFrontend.validaNumero("¿Cual es el stock maximo del producto? ", 0, 200);
		String proveedor = null;
		float pvp = (float) LibFrontend.validaNumeroDouble("Precio: ", 0.10, 200.0);
		String nombre = LibFrontend.leer("Nombre del producto: ");
		String comentarios = LibFrontend.leer("Comentario sobre el producto: ");

		Main.listaProductos.add(new Producto(codigoProducto, grupo, otros, stockActual, stockMinimo, stockMaximo,
				proveedor, pvp, nombre, comentarios));
	}

	public static void borrarProducto() {
		if (JOptionPane.showConfirmDialog(Main.main,
				"¿Desea borrar el producto " + Main.main.txtFieldCodigo.getText() + "?", "Borrar producto",
				2) == JOptionPane.YES_OPTION) {
			Main.listaProductos.remove(codigo);
		}
	}

	public static void guardarProducto() {

		LogicOperations.escribirEnFich(Main.listaProductos, nombreFichero);
	}

	public static List <Producto> cargarDatos() {

		List <Producto> listaProductos = LogicOperations.getFich(nombreFichero);
		return listaProductos;	
	}

}
