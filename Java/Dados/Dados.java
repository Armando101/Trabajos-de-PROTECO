import java.util.Random;
import java.util.Arrays;
public class Dados {
	int arr[];

	public int [] tirar(int v) {

		arr = new int [v];


		Random aleatorio = new Random();
		
		for (int i=0; i<arr.length; i++) 
			arr[i] = aleatorio.nextInt(12)+1;
		
		Arrays.sort(arr);
		return arr;

		}

	public int[] ordenar (int [] ord) {
		int j=1;	int k=0;	int [] nuevo = new int [12];

		for (int i=0;i<ord.length; i++) {
			if (ord[i]==j) 
					k++;
			else {
				nuevo[j-1] = k;
				j++;
				k=1;
			}
		}
		nuevo[11]=k;
		return nuevo;

	}  

    public void imprimir(int [] arrAleatorio) {
    	for (int i=0; i<arrAleatorio.length; i++ ) {
			if (i > 9)
				System.out.printf("%d: ", i+1);
			else
				System.out.printf("%02d ",i+1);

			//Imprimir asteriscos

			for (int asterisco=0; asterisco<arrAleatorio[i]; asterisco++)
				System.out.print("*");
			System.out.println();
		}

    }




}
