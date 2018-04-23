import java.util.Scanner;
import java.util.ArrayList;

public class Agenda {
    String nombrep,nombrem,telefono;
    boolean cond = true;
    ArrayList<Persona> directorio = new ArrayList<Persona>();
    
    public void Opciones() {
    System.out.println("Ingrese la opcion de la Accion que desea realizar");
    System.out.println("1)Agregar Persona");
    System.out.println("2)Buscar Persona");
    System.out.println("3)Eliminar persona");
    System.out.println("4)Vaciar Directorio");
    System.out.println("5)Ver Directorio");
    System.out.println("6)Salir");
        
        try{
            Scanner teclado = new Scanner(System.in);
            int opcion=teclado.nextInt();
            switch(opcion){
                case 1:
                    Agregar();
                break;
                case 2:
                	Buscar();
                break;
                case 3:
                    Eliminar();
                break;
                case 4:
                    Vaciar(); 
                break;
                case 5:
                	Ver();
                break;
                case 6:
                	cond = false;
                break;
                default :
                   	System.out.println("Ingrese una opcion valida"); 
                break;
                }
        } catch(Exception e){}       
    }

    public void Agregar() {
    	Scanner teclado1 = new Scanner(System.in);
        System.out.println("Ingrese nombre de la Persona que desea agregar");
        nombrep=teclado1.nextLine();
        System.out.println("Ingrese el numero de telefono");
        telefono=teclado1.nextLine();
        System.out.println("Ingrese el nombre de su mascota");
        nombrem=teclado1.nextLine();
        Persona p = new Persona(nombrep,telefono,nombrem);
        directorio.add(p);
    }

    public void Buscar() {
        System.out.println("Ingrese el nombre de la persona que desea buscar");
        Scanner teclado2 = new Scanner(System.in);
        nombrep=teclado2.nextLine();
        for (int  i = 0; i < directorio.size(); i++)
            if(nombrep.equals(directorio.get(i).getNombre())){
                System.out.println(directorio.get(i).getNombre());
                System.out.println(directorio.get(i).getNumero());
                System.out.println(directorio.get(i).getMascota());
                teclado2.nextLine();
                return;
                }
        System.out.println("Persona no registrada");
        teclado2.nextLine();
    }

    public void Eliminar() {
    	System.out.println("Ingrese el nombre de la persona que desea eliminar");
        Scanner teclado3 = new Scanner(System.in);
        nombrep=teclado3.nextLine();
        for (int  i = 0; i < directorio.size(); i++)
            if(nombrep.equals(directorio.get(i).getNombre())) {
                directorio.remove(i);
                System.out.println("Persona eliminada");  
                teclado3.nextLine(); 
            return;
            }
       	System.out.println("Persona no registrada");
        teclado3.nextLine();	
    }

    public void Vaciar() {
    	try {
    	Scanner teclado4 = new Scanner(System.in);
    	System.out.println("Vaciando el directorio...");
        Thread.sleep(2000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("...");
        System.out.println("Directorio vacio");
        directorio.clear();
        teclado4.nextLine();
    	}catch(Exception e){}
    }

    public void Ver() {
    	Scanner teclado5 = new Scanner(System.in);
        for (int  i = 0; i < directorio.size(); i++) {
            System.out.println(directorio.get(i).getNombre());
            System.out.println(directorio.get(i).getNumero());
            System.out.println(directorio.get(i).getMascota());
            System.out.println();
            System.out.println();
        }
        teclado5.nextLine();
    }

    public boolean getBool() {
    	return cond;
    }
}