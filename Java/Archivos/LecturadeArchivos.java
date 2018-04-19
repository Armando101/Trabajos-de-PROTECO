import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class LecturadeArchivos {
public static void main(String[] args) {
	//Leer archivo = new Leer();
	//archivo.leer();
	LeerBuffer lb = new LeerBuffer();
	lb.lectura();
	}
}

class Leer {
	public void leer() {
		try{
			FileReader fr = new FileReader("/home/armando/Documentos/pruebalectura");
			int caracter;
			while ((caracter = fr.read()) != -1 ) {
				char c = (char)caracter;	//Esto es para que no nos imprima la representacion en unicode 
				System.out.print(c);
			}
			fr.close();
		}
		catch(IOException  e){}
	}
}

class LeerBuffer {
	public void lectura() {
		try{
			File f = new File("/home/armando/Documentos/pruebalectura");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
		}
		catch(IOException e){}
	}
}