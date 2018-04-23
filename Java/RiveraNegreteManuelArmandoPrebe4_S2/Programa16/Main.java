import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        Rombo rombo = new Rombo();
        System.out.print("Ingresa un numero: ");
        while (true) {
        	try {
        	Scanner teclado = new Scanner(System.in);        
    		int numero=teclado.nextInt();           
        	rombo.asterisco(numero);
        	break;
        	}catch(Exception e) {
        		System.out.println("Ingrese un numeo entero");
        	}
    	}
    }
    
}