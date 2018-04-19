import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor1 extends Thread {
	private  String nombreCliente;
	private  BufferedReader entrada;

	public Servidor(Socket s) throws IOException {
		entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
		nombreCliente = s.getInetAdress().getCanonicalHostname();
		System.out.println("Conexion aceptada desde " + s.getRemoteSocket);
	}

	public String recibir() throws IOException {
		String str = entrada.readLine();
		return str;
	}

	public void cerrar() throws IOException {
		entrada.close();
	}

	@Override
	public void run() {
		try {
			String cadena = "";
			do {
				cadena = recibir();
				System.out.println(nombreCliente + " dice: " + cadena);
			}while (!cadena.equals("Salir"))
		}catch (IOException e) {
			System.out.println("Se cerro la Conexion con " + nombreCliente);
		}finally {
			try {
				cerrar();
			}catch(IOException){}
		}
	}

	public static void main(String[] args) throws IOException{
		ServerSocket ss;
		ss = new ServerSocket(0);
		System.out.println("Servidor aceptando Conexiones en el puerto: " + ss.getLocalPort());

		while (true) {
			Socket client = ss.accept();
			Servidor hilo = new Servidor(client);
			hilo.start();
		}

	}
}