/**
*	@author Armando Rivera
*/
import java.util.Scanner;
public class Calculadora {
	double num1;
	double num2;

	/**
	*	Este constructor recibe dos parametros
	*	@param num1 Primer numero ingresado a operar con el segundo
	*	@param num2 Segundo numero a operar
	*/

	public Calculadora(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	/**
	*	Realiza las operaciones
	*	@param op Recibe la operacion a realizar
	*	@return Regresa la operacion realizadad
	*/

	public double Opciones(String op) {
		switch (op) {
			case "Suma":
				return num1 + num2;
			case "Resta":
				return num1 - num2;
			case "Multiplicacion":
				return num1 * num2;
			case "Division":
				if (num2 == 0)
					System.out.println("No se puede dividir entre cero");
				return num1 / num2;
			default:
				System.out.println("Opcion invalida");
				return 0;
		}
	}

}