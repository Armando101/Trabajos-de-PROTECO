/*
	Rango de califs
	00-09
	10-19
	20-29
	.....
	.....
	.....  
	90-99    Instrucciones del Programa
*/ 

public class GraficoBarras {
	public static void main(String[] args) {
		
		int  [] arreglo = {20,5,7,9,4,5,21,15,3,15,10};
		System.out.println("Distribucion "); //Para cada elemento del arreglo imprimir una barra del grafico

		for (int i=0; i<arreglo.length; i++ ) {
			if (i == 10)
				System.out.printf("%5d: ", 100);
			else
				System.out.printf("%02d-%02d: ",i*10, i*10+9);

			//Imprimir asteriscos

			for (int asterisco=0; asterisco<arreglo[i]; asterisco++)
				System.out.print("*");
			System.out.println();
		}



	}
}