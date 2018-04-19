import java.io.FileWriter;
import java.io.IOException;
public class SinBuffer {
	public static void main(String[] args) {
		EscrituraSinBuffer esb =new EscrituraSinBuffer();
		esb.escribir();
	}
}

class EscrituraSinBuffer {
	public void escribir() {
		try{
			String cadena = "Hola, estoy escribiendo\n Hola";
			FileWriter fw = new FileWriter("/home/armando/Documentos/pruebalectura");
			for (int i =0; i< cadena.length();i++ ) {
				fw.write(cadena.charAt(i));
			}
			fw.close();
		}catch (IOException e) {}
	}
}