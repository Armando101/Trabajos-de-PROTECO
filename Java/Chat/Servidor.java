import java.io.IOException;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;

public class Servidor {
	public static void main(String[] args) throws IOException {
		//Paso 1: Crear el socket servidor
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("Esperando la conexion en el puerto...");

		String cadena = "";
		//Paso 2: Espera la conexion
		Socket s = ss.accept();
		System.out.println("Conexion aceptada desde " + s.getInetAddress());

		//Paso 3: Obtener los flujos de I/0 del Socket
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//Paso 4: Realizar el procesamiento
		while (!cadena.equals("quit")) {
			cadena = br.readLine();
			System.out.println(cadena);
		}

		//Paso 5: Cerrar la conexion
		br.close();
		s.close();
		ss.close();

	}
}