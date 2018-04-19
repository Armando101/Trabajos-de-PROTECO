import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		String op;
		int tam;
		double mat;

		System.out.println("Bienvenido a la calculadora de matrices");
		System.out.println("Ingrese la operacion que desea realizar");

		System.out.println("Suma    Resta    Multiplicacion");
		Scanner operacion = new Scanner(System.in);
		op = operacion.nextLine();

		System.out.println("Ingrese el tamanio de sus matrices");
		Scanner tamanio = new Scanner(System.in);
		String ta = tamanio.nextLine();
		tam = Integer.parseInt(ta);


		double m1 [][] = new double [tam] [tam];
		double m2 [][] = new double [tam] [tam];
		double m3 [][] = new double [tam] [tam];


		System.out.println("Ingrese sus matrices");
		System.out.println("Matriz 1)");

		for (int i=0; i<tam; i++) 
			for (int j=0; j<tam; j++) {
				System.out.printf("Elemento [%d][%d]:\n", i+1, j+1);
				Scanner m = new Scanner(System.in);
				String ma = m.nextLine();
				mat = Double.parseDouble(ma);
				m1[i][j] = mat;
			}
		
		System.out.println("Matriz 2)");

		for (int i=0; i<tam; i++) 
			for (int j=0; j<tam; j++) {
				System.out.printf("Elemento [%d][%d]:\n", i+1, j+1);
				Scanner m = new Scanner(System.in);
				String ma = m.nextLine();
				mat = Double.parseDouble(ma);
				m2
				[i][j] = mat;
			}

		

		Matrices calculadora = new Matrices(tam, m1, m2, op);
	}
}