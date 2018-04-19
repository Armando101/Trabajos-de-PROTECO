import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintStream;

public class Cliente1 {
	private PrintStream ps;
	private String host;
	private int port;

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void conectar() throws IOException {
		Socket s = new Socket(host, port);
		ps = new PrintStream(s.getOutputStream());
	}

	public void send(String message) throws IOException {
		ps.println(message);
	}

	public void close() throws IOException {
		ps.close();
	}


	public static void main(String[] args) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Cliente cliente = new Cliente();
		System.out.println("Host: ");
		cliente.setHost(teclado.readLine());

		System.out.println("\nPuerto: ");
		cliente.setPort(Integer.parseInt(teclado.readLine()));

		cliente.conectar();
		String cadena = "";
		while (!cadena.equals("Salir")) {
			cadena = teclado.readLine();
			cliente.send(cadena);	
		}

		cliente.close();
	}
}	

