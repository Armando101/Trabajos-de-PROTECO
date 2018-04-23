import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	private static Scanner teclado = new Scanner(System.in); 
	private static ArrayList<String> binarios = new ArrayList<String>();

	public static void main(String[] args) 
	{
		System.out.print("Ingresa los numeros separados por un espacio: ");
		try 
		{

			String numeros = teclado.nextLine();
			String[] arrNums = numeros.split(" ");
			for (int i = 0; i < arrNums.length; i++) 
			{
				int res = Integer.parseInt(arrNums[i]);
				String binario = Integer.toBinaryString(res);
				binarios.add(binario);
			}
			System.out.println(binarios);
		}
		catch(Exception e) 
		{
			System.out.println("Ingrese un numero valido");
		}
	}
}
