public class Computadora implements Encendible, Apagable {
	public void encender() {
		System.out.printf("\nBienvenido\nIniciando Sesion\n");
	}

	public void apagar() {
		System.out.println("Has cerrado Sesion");
	}
}