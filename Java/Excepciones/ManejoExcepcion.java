public class ManejoExcepcion {
	public static void main(String[] args) {
		MetodosException me = new MetodosException();

		try {
			me.lanzarExcepcion();
		} catch (MiException mie) {
			System.out.println(mie);
			mie.hola();
			mie.getMessage();
		}
	}
}