import java.util.ArrayList;
/**
*	@author Armando Rivera
*/
public class MultiplicacionMatrices {
	/**
	* @param tam Tamanio de las matrices
	* @param m1 Matriz 1 a ser multiplicada
	* @param m2 Matriz 2 a ser multiplicada
	* @return Regresa la multiplicacion de las matiz
	*/
	public double[][] Multiplicacion(int tam, double [][] m1, double [][] m2) {
		
		double[][] n3 = new double[tam][tam];
		double aux=0;		//Variable auxiliar la cual va haciendo las sumas de las multiplicaciones
		
		for (int k=0; k<tam; k++)
			for (int i=0; i<tam; i++) {
				for (int j=0; j<tam; j++) 
					aux += m1[k][j] * m2[j][i];
				n3[k][i] = aux;
				aux = 0;
			}
		return n3;
	}
}