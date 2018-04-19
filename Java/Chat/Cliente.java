import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws IOException {
		//Paso1: Crear un Socket para conectar con el servidor
		Socket s = new Socket("192.168.1.147", 9999);

		String cadena = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		//Paso 2: Obtener los flujos de I/O del Socket
		PrintStream ps = new PrintStream(s.getOutputStream());

		//Paso 3: Realizar Procesamiento
		while (!cadena.equals("quit")) {
			cadena = teclado.readLine();
			ps.println(cadena);
			ps.flush();
		}

		//Paso 4: Cerrar la conexion
		ps.close();
		teclado.close();
		s.close();
	}
}