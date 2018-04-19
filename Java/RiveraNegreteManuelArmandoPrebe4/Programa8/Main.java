import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		double num1;
		double num2;
		String op;
		
		while (true) {
			
			System.out.println("\n\nBienvenido a la PrebeCalculadora");
			System.out.println("Ingresa Dos numeros");
		
			try {			//Verifica que se haya ingresado un numero y no otro caracter
				Scanner n1 = new Scanner(System.in);
				String nn1 = n1.nextLine();
				num1 = Double.parseDouble(nn1);

				Scanner n2 = new Scanner(System.in);
				String nn2 = n2.nextLine();
				num2 = Double.parseDouble(nn2);

				Calculadora cal = new Calculadora(num1, num2);
				System.out.println("\n\nIngresa la operacion a realizar");
				System.out.println("Suma	Resta	Multiplicacion	Division");
				System.out.println("Salir\n");

				Scanner sc = new Scanner(System.in);
				op = sc.nextLine();

				switch (op) {
					case "Salir":
						return; 
					default:
					System.out.printf("%.2f\n", cal.Opciones(op));
				}
			}catch (NumberFormatException e) {
				System.out.println("Opcion invalidas");
			}
		}
	}
}
