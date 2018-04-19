public class Carro {

	double peso, altura;
	boolean encendido = false;
	String modelo;
	boolean turbo = false;

	public Carro(double peso, double altura) {

		this.peso = peso;
		this.altura = altura;
	}

	public void setModelo(String mod) {
		modelo = mod;
	}

	public String getModelo(){
		return modelo;
	}

	public boolean Turbo(boolean a) {
		if (a) {
			System.out.println("Tengo turbo");
			turbo = true;
			return turbo;
		}
		else {
			turbo = false;
			System.out.println("No Tengo turbo");
			return turbo;
		}
	}

	public boolean Encender() {
		encendido = true;
		System.out.println("El auto esta encendio");
		return encendido;
	}

	public boolean Apagar() {
		encendido = false;
		System.out.println("El auto se apago");
		return encendido;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	public boolean Estado() {
		if (encendido) 
			System.out.println("Esta encendido");
		else 
			System.out.println("El Carro esta apagado");
		return encendido;
	}

	public String toString() {
		return String.format("El peso es: %.2f\nLa altura es: %.2f ", peso, altura);
	}
}