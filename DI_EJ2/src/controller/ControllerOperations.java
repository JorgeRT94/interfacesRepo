package controller;

import java.sql.Connection;

import javax.swing.JTextArea;

import logic.LogicDB;

public class ControllerOperations {

	public static void mostrarConsulta(Connection connection, String consultaSQL, JTextArea textAreaResultado) {

		LogicDB.resultadoConsulta(connection, consultaSQL, textAreaResultado);

	}

	public static void cargarConsulta(String rutaFch, JTextArea textArea) {

		LogicDB.cargarFchConsulta(rutaFch, textArea);

	}

	public static void guardarConsulta(String rutaFch, JTextArea textAreaConsulta, JTextArea textAreaResultado) {

		LogicDB.escribirFch(rutaFch, textAreaConsulta, textAreaResultado);

	}

}
