package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextArea;

import dbm.DB_Oracle;

public class LogicDB {

	public static void resultadoConsulta(Connection connection, String consultaSQL, JTextArea textAreaResultado) {

		if (connection != null) {
			ResultSet rs = DB_Oracle.getData(connection, consultaSQL);
			ResultSetMetaData rsm;

			try {

				rsm = rs.getMetaData();

				String resultadoConsulta = " ";

				for (int i = 1; i < rsm.getColumnCount() + 1; i++) {
					resultadoConsulta += rsm.getColumnName(i) + "\t";
				}

				while (rs.next()) {

					resultadoConsulta += "\n";

					for (int i = 1; i < rsm.getColumnCount() + 1; i++) {
						resultadoConsulta += rs.getString(i) + "\t";
					}
				}

				textAreaResultado.setText(resultadoConsulta);
				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void cargarFchConsulta(String rutaFch, JTextArea textArea) {

		try {

			FileReader fileReader = new FileReader(rutaFch);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			textArea.read(bufferedReader, null);
			bufferedReader.close();
			textArea.requestFocus();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void escribirFch(String rutaFch, JTextArea textAreaConsulta, JTextArea textAreaResultado) {

		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaFch));

			textAreaConsulta.write(bufferedWriter);
			textAreaResultado.write(bufferedWriter);

			bufferedWriter.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
