package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class LogicFich {
	

	
	public static void leerFch (String rutaFch, JTextArea textArea) {
		
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
	
	public static void escrbirFch (String rutaFch, JTextArea textArea) {
		
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaFch));
			
			textArea.write(bufferedWriter);
			
			
			bufferedWriter.close();
			textArea.requestFocus();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
