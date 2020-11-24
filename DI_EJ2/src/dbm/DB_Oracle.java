package dbm;

import java.sql.*;

import view.Conexion;

public class DB_Oracle {
	
	// Configurar la base de datos antes de definir los datos de conexion.
	private static String DB_HOST = Conexion.txtFieldHost.getText();
	private static String DB_PORT = Conexion.txtFieldPort.getText();
	private static String DB_SID = Conexion.txtFieldSID.getText();

	private static String DB_USER = Conexion.txtFieldUser.getText();
	private static String DB_PASS = Conexion.txtFieldPass.getText();
	public static boolean isConected;

	public static Connection getConnection() {

		String DB_URL = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + "/" + DB_SID;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			isConected = true;
			
		} catch (SQLException e) {
			
			System.err.println("NO CONECTADO");
			System.err.println(e.getMessage());
		}
		return conn;
	}
		

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("No se ha podido cerrar la conexion.");
			System.err.println(e.getMessage());
		}
	}

	public static ResultSet getData(Connection conn, String sql) {
		ResultSet resultado = null;
		Statement ordenSQL;
		try {
			ordenSQL = conn.createStatement();
			resultado = ordenSQL.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la orden: " + sql);
			System.err.println(e.getMessage());
		}

		return resultado;
	}

	public static int executeSQL(Connection conn, String sql) {
		Statement ordenSQL;
		int result = 0;
		try {
			ordenSQL = conn.createStatement();
			result = ordenSQL.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la orden: " + sql);
			System.err.println(e.getMessage());
		}

		return result;
	}
}
