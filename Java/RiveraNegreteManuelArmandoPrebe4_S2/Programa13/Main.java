import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
    public static void main(String[] args) {
        int num1=0; 
        int num2=0;
        
        while (true) {
        try
        {
            System.out.println("Ingresa el primer numero");
            Scanner teclado = new Scanner(System.in);
            num1 = teclado.nextInt();
            break;
        }   
        catch (InputMismatchException ime) {
            System.out.println("Valor invalido");}
        }
        while(true){
        try
        {
            Scanner teclado2 = new Scanner(System.in);
            System.out.println("Ingresa el segundo numero");
            num2 = teclado2.nextInt(); 
            int r=num1/num2;
            break;
        }
        catch (ArithmeticException ae) {
            System.out.println("Valor invalido"); 
        }
        catch (InputMismatchException ime) {
        System.out.println("Valor invalido"); }
        }

    Simplificar s = new Simplificar(num1, num2);
    }
}
