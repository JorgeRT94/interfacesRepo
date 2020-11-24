package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class LogicOperations {

	public static List<Producto> llenarLista(List<Producto> listProductos, Producto producto) {

		listProductos.add(producto);

		return listProductos;
	}
	

	public static void escribirEnFich (List<Producto> listProducto,String ruta) {
		
        try {

            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(ruta));

            objectOutput.writeObject(listProducto);
            System.out.println("Datos añadidos.");

            objectOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
	
    public static List<Producto> getFich(String FILE_NAME_OBJ) {
        List<Producto> listProducto = new ArrayList<Producto>();

        try {

            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(FILE_NAME_OBJ));

            listProducto = (List<Producto>) objectInput.readObject();

            objectInput.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listProducto;
    }

}
