import java.util.Scanner;
import java.util.InputMismatchException;
class Main {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {   try{
                System.out.println("Calculadora de determinantes\n");
                System.out.println("Ingresa el orden de tu matriz");
                int orden= sc.nextInt();
                if (orden == 0){
                    System.out.println("no hay matrices de orden 0");
                    System.out.println("Ingrese un orden valido");
                }else{

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    Matriz nueva= new Matriz(orden);
                    nueva.llenar();

                    double det= nueva.getDeterminante(nueva, 0);
                    System.out.println("el determinante de esta matriz es  "+det);
                    break;
                }
            }catch (InputMismatchException ime) {
                System.out.println("Ingrese una opcion valida");
            }   
        }
    }
}
