import java.util.Random;
//import java.util.Scanner;

class Aleatorio {
	public static void main(String[] args) {
		System.out.println("Esta es una prueba de Arreglos Random ");

		int arreglo1[] = new int[5];
		int arreglo2[] = new int[5];
		
		Random aleatorio = new Random();
		for (int i=0; i<arreglo1.length; i++) {
			arreglo1[i] = aleatorio.nextInt(5)+1;
			arreglo2[i] = aleatorio.nextInt(5)+1;
		}

		System.out.println("Arreglo 1: ");
		for (int i=0; i<arreglo1.length; i++ )
			System.out.println(arreglo1[i]);
		

		System.out.println("Arreglo2");
		for (int i=0; i<arreglo2.length; i++ )
			System.out.println(arreglo2[i]);
		
	}
}