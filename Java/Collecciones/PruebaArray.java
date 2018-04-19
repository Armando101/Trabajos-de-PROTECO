import java.util.Arrays;
import java.util.Random;

public class PruebaArray {
	public static void main(String[] args) {
		int num[] = new int[10];
		Random ran = new Random();
		ran.setSeed(System.currentTimeMillis()); //Todo el tiempo que ha pasado Desde el 1 de enero de 1970
			
		for (int i = 0; i<num.length;i++)
			num[i]=ran.nextInt(100);
		int[] antes = (int []) num.clone();	//Casteo a arreglo
		System.out.println("Arreglo num es igual antes de ser ordenado: " + Arrays.equals(antes, num));
		Arrays.sort(num);
		System.out.println("Arreglo num es igual despues de ser ordenado: " + Arrays.equals(antes, num));
		System.out.println("Antes = " + Arrays.toString(antes));
		System.out.println("Despues = " + Arrays.toString(num));
		System.out.println("Busqueda del numero 4, Resultado: " + Arrays.binarySearch(num, 4));
			
	}
}