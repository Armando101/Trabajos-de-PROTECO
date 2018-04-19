import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConBuffer {
	public static void main(String[] args) {
		EscrituraConBuffer ecb = new EscrituraConBuffer();
		ecb.escribe();
		
	}
}

class EscrituraConBuffer {
	public void escribe() {
		String cadena;
		File archivo;
		FileWriter fw;
		BufferedWriter bw;

		try{
			archivo = new File("/home/armando/Documentos/pruebalectura");
			fw = new FileWriter(archivo, true);		//El true es para que no se sobreescriba
			bw = new BufferedWriter(fw);
			Scanner teclado = new Scanner(System.in);
			do{
				cadena = teclado.nextLine();
				bw.write(cadena + "\n");
			}while (!cadena.equals("adios"));
			bw.flush();
			bw.close();
			fw.close();
		}
		catch (IOException e) {}
	}
}