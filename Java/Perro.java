public class Perro {
	public String nombre;
	public int edad;

	Perro(){

	}

	Perro(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public String getNombre() {
		return nombre;
	}

	public void traer(){
		System.out.println("Ahhhhhh perro traes el ocnitirx");

	}

	public void recibir(String r) {
		System.out.printf("%s Esta recibiendo el %s \n", nombre, r);
	}

	public void dar(String d) {
		System.out.printf("%s Esta dando el %s \n",nombre, d);

	}
}