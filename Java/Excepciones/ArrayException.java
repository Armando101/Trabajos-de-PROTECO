import java.util.Scanner;
import java.util.InputMismatchException;

public class ArrayException {
	public static void main(String[] args) {
	/*
		try {
			int[] numeros = {1,2,3,4};
			System.out.println(numeros[8]);
			System.out.println("Todo Bien");
		
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Te excediste del rango del arreglo");
		}
	*/
		Scanner sc = new Scanner(System.in);
		int x,y;
		System.out.println("Ingresa un numero");
		try {
			x=sc.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("No se ingreso numero");
			System.out.println(ime.getMessage());
		} finally {
			System.out.println("Siempre se ejecuta");
			x=4;
		}

		String cadena;

		System.out.println("Ingresa un numero para ser el divisor");

		try {
			sc.nextLine();				//Espera el enter para continuar
			cadena = sc.nextLine();
			y = Integer.parseInt(cadena);
			System.out.println("El resultado es: " + (x/y));
		}catch (NumberFormatException nfe) {
			System.out.println("No se ingreso un numero");
		}catch (ArithmeticException ae) {
			System.out.println("No se puede dividir entre 0");
		}
/*
	ClassCastException
		object x = new Integer(20);
		String s = (String) x;
*/
		
/* 
	NegativeArraySizeException
		int[] arreglo = new int[-2];
*/

/*
	NullPointerException
		object[] a = new Object[3];
		a[2].toString();
*/

	}
}