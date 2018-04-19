import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Copia {
	public static void main(String[] args) {
			
			CopiadeArchivo cpa = new CopiadeArchivo();
			cpa.copiar();	//Recibe dos rutas
											//A copiar y destino
	}
}

class CopiadeArchivo {
	public void copiar() {

		try{
			String cadena;
			File archivo;
			FileWriter fw;
			BufferedWriter bw;

			File f = new File("/home/armando/Documentos/pruebalectura1");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			archivo = new File("/home/armando/Documentos/pruebalectura2");
				
			while ((linea = br.readLine())!=null) {		
				fw = new FileWriter(archivo, true);		//El true es para que no se sobreescriba
				bw = new BufferedWriter(fw);
				do{
					bw.write(linea + "\n");
				}while (!cadena.equals(null));
				bw.flush();
				bw.close();
				fw.close();
				br.close();
				fr.close();
			}
		}catch(IOException  e){}

	}
}
