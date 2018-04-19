/**
*	@author Armando Rivera
*/

import java.util.ArrayList;
public class RestaMatrices {
	
	/**
	* @param tam Tamanio de las matrices
	* @param m1 Matriz 1 a ser restada
	* @param m2 Matriz 2 a ser restada
	* @return Regresa la suma de la matiz
	*/
	public double[][] Resta(int tam, double [][] m1, double [][] m2) {
		double[][] n3 = new double[tam][tam];
		for (int i=0; i<tam; i++) 
			for (int j=0; j<tam; j++)
				n3[i][j] = m1[i][j] - m2[i][j];
		return n3;
	}


}