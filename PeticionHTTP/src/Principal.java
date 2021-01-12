import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Principal {

	public static List <Coche> listCoches;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			String url = "http://jrtmedac.atwebpages.com/consultaMarcas.php";
			String respuesta = peticionHttp(url);
			
			
			listCoches = JsonToMarcaCoches(respuesta);
			listCoches.forEach((c) -> System.out.println(c));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			
		}
	}

	private static List<Coche> JsonToCoches(String respuesta) {

		List<Coche> listResultados = new ArrayList<>();
		
		JSONArray jsonArray = new JSONArray(respuesta);
		
		for (int i = 0; i < jsonArray.length(); i++) {
			
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Coche c = jsonCoche(jsonObject);
			listResultados.add(c);
		}
		
		return listResultados;
	}
	
	public static List<Coche> JsonToMarcaCoches(String respuesta) {

		List<Coche> listResultados = new ArrayList<>();
		
		JSONArray jsonArray = new JSONArray(respuesta);
		
		for (int i = 0; i < jsonArray.length(); i++) {
			
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Coche c = jsonMarcaCoche(jsonObject);
			listResultados.add(c);
		}
		
		return listResultados;
	}

	private static Coche jsonCoche(JSONObject jsonObject) {
		
		int id = jsonObject.getInt("id_coche");
		String marca = jsonObject.getString("marca");
		String modelo = jsonObject.getString("modelo");
		int potencia = jsonObject.getInt("potencia");
		
		Coche c = new Coche (id, marca, modelo, potencia);
		
		return new Coche (jsonObject.getInt("id_coche"), jsonObject.getString("marca"), jsonObject.getString("modelo"), jsonObject.getInt("potencia"));
	}
	
	private static Coche jsonMarcaCoche(JSONObject jsonObject) {
		
		String marca = jsonObject.getString("marca");
		Coche c = new Coche ();
		c.setMarca(marca);
		
		return c;
	}

	private static String peticionHttp(String parametro) {

		StringBuilder resultado = new StringBuilder();
		
		try {
			
			URL url = new URL(parametro);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			
			
			//recoger los datos de la respuesta
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			
			while ((linea = bufferedReader.readLine()) != null) {
				
				resultado.append(linea);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultado.toString();
	}

}
