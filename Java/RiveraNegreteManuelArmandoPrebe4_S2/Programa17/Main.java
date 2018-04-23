import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Torres t = new Torres();
		
		System.out.print("Ingresa el numero de discos: ");
		Scanner teclado = new Scanner(System.in);
		int discos = teclado.nextInt();
		System.out.println();
		t.Proceso(discos, 'A', 'B', 'C');
		System.out.println();
	}
}