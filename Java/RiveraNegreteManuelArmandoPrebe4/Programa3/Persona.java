public class Persona {
	String nombre;
	int edad;
	double estatura;
	double peso;

	public void setNombre(String n) {
		nombre = n;
	}

	public void setEdad(int ed) {
		edad = ed;
	}

	public void setEstatura(double es) {
		estatura = es;
	}

	public void setPeso(double p) {
		peso = p;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getEstatura() {
		return estatura;
	}

	public double getPeso() {
		return peso;
	}
}