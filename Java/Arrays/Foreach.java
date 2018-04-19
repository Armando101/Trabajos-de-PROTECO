public class Foreach {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int total = 0;

		//fFor mejorado (Foreach)

		for (int i : arr )
			total+=i;

		System.out.println("El total de la suma del arreglo es: "+total);
		
	}
}