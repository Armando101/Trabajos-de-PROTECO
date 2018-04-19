public class PruebaPerro {
	public static void main(String[] args) {
		Perro prro = new Perro();
		Perro prro1 = new Perro("Firulais", 3);


		prro1.traer();
		prro1.recibir("ocnitrix");
		prro1.dar("ocnitrix");


		prro.setNombre("Peluchin");
		System.out.println("El nombre del perro es " + prro.getNombre());
	
	}

}