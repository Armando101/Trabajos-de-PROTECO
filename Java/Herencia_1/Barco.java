public class Barco extends VehiculoAcuatico {
	public Barco(String nombre) {
		super(nombre);
	}

	public void encenderMotores() {
		System.out.println("Estoy encendiendo los Motores");
	}

	@Override		//SobreEscritura
	public void navegar() {
		System.out.println("Soy un Barco y mi nombre es " + nombre);
	}
}