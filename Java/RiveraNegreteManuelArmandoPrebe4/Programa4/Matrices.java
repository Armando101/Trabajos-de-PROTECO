/**
*	@author Armando Rivera
*/

import java.util.ArrayList;
public class Matrices {
	
	int tam;
	double n3[][] = new double[tam][tam];	//Esta matriz sera la resultante de la operacion especificada 
	String op;								//Opcion elegida por el usuario
	/**
	* @param tam Recibe el tamanio de las matrices
	* @param m1 Matriz 1 a ser restada com Matriz 2
	* @param m2 Matriz 2 a ser restada con Matriz 1
	* @param op Operacion a realizar
	*/
	public Matrices(int tam, double [][] m1, double [][] m2, String op) {
	
		this.tam = tam;
		this.op = op;

		switch (op) {
			case "Suma" :
				SumaMatrices sm = new SumaMatrices();
				n3=sm.Suma(tam, m1, m2);
				this.Imprimir(n3);
				break;
			case "Resta" :
				RestaMatrices rm = new RestaMatrices();
				n3 = rm.Resta(tam, m1, m2);
				this.Imprimir(n3);
				break;
			case "Multiplicacion" :
				MultiplicacionMatrices mm = new MultiplicacionMatrices();
				n3 = mm.Multiplicacion(tam, m1, m2);
				this.Imprimir(n3);
				break;
			
			default:
				System.out.println("Ingrese una opcion valida");
		}	
	}

	public void Imprimir(double [][] mx) {
		for (int i = 0; i<tam; i++) {
			for (int j=0; j<tam; j++) 
				System.out.printf("%.2f ", mx[i][j]);
			System.out.printf("\n");
		}
	}

}
