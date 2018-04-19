import java.util.*;
public class Main {
	public static void main(String[] args) {

		System.out.println("Ingrese la base de su Rectangulo");

		
		Scanner teclado1 =new Scanner(System.in);	//Leer parametros
		String base = teclado1.nextLine();
		double ba=Double.parseDouble(base);

		System.out.println("Ingrese la altura de su Rectangulo");

		Scanner teclado2 =new Scanner(System.in);
		String altura = teclado2.nextLine();
		double al=Double.parseDouble(altura);

		System.out.println("Ingrese el tamanio que quiere agrandar su Rectangulo");
		
		Scanner teclado =new Scanner(System.in);
		String agrandar = teclado.nextLine();
		int x=Integer.parseInt(agrandar);


		Rectangulo r1 = new Rectangulo(ba, al);	//A este objeto le pasaremos parametros
		Rectangulo r2 = new Rectangulo();			//este objeto sera para guardar el objeto 1 al doble

		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.printf("Las dimenciones del Rectangulo creado originalmente son: \nBase: "+base+"	Altura: " + altura + "\n\n");
		System.out.printf("Area: %f     Perimetro: %f\n\n", r1.calcularArea(), r1.calcularPerimetro());

		r2=r1.agrandar(x);	//Casteamos de double a String
		String baseX = String.valueOf(r2.getBase());
		String alturaX = String.valueOf(r2.getAltura());

		System.out.printf("\n\nLas dimenciones de su Rectangulo agrandado son: \nBase: "+baseX+"	Altura: "+alturaX+"\n\n");
		System.out.printf("Area: %f     Perimetro: %f\n\n", r2.calcularArea(), r2.calcularPerimetro());
			 
	}


}