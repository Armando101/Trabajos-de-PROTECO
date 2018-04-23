import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda a = new Agenda();
         
        do{
            a.Opciones();
            System.out.println();
            
            System.out.print("\033[H\033[2J");
            System.out.flush();

        }while (a.getBool()); 
    }
}