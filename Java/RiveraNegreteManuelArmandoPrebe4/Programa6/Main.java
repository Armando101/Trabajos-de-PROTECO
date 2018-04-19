public class Main {

	public static void main(String[] args) {
		
			Carro c = new Carro(500, 1.20);

			c.Estado();
			c.Encender();
			c.Estado();
			c.Turbo(true);
			System.out.println(c);
			c.setModelo("BMW");
			System.out.printf("El modelo es: %s\n",c.getModelo());
	}
}