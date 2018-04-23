import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {

		Cesar c = new Cesar();
		Scanner teclado = new Scanner(System.in);
		try {
			if(args[0].equals("0")){
				System.out.print("\n Ingresa la cadena a cifrar: ");
				String palabra = teclado.nextLine();
				c.Descifrar(palabra);
			}
			else if (args[0].equals("1")) {
				System.out.print("\n Ingresa la palabra a Descifrar: ");
				String palabra = teclado.nextLine();
				c.Cifrar(palabra);
			}
			else {
				System.out.println("Ingrese un argumento valido");
				System.out.println("0 para cifrar");
				System.out.println("1 para Descifrar");
			}
		}catch (ArrayIndexOutOfBoundsException aibe) {
			System.out.println("Ingrese un argumento valido");
			System.out.println("0 para cifrar");
			System.out.println("1 para Descifrar");
		}
	}
}