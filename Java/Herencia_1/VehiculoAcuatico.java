public class VehiculoAcuatico extends Vehiculo {
	String nombreAcuatico;
	
	public  VehiculoAcuatico(String nombre) {
		super(nombre);			//Hace referencia al constructor de la clase padre
	}

	public void navegar() {
		System.out.println(super.transportar() + "Acuatico");
	}

	
	
}