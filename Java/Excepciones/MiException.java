public class MiException extends Exception {
	@Override
	public String toString() {
		return "Mi Propia Excepcion ";
	}

	public String getMessage() {
		return "Este es nuestro propio mensaje";
	} 

	public void hola() {
		System.out.println("hola mundo desde la Excepcion");
	}

}