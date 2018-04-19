import java.util.Scanner;
public class MetodosException {
	public void lanzarExcepcion() throws MiException {//Si queremos poner mas de una excepcion, estas vanseparadas por coma
		Scanner sc = new Scanner(System.in);
		System.out.println("Presiona 1 para lanzar la Excepcion");
		int i = sc.nextInt();
		if (i==1) {
			throw new MiException();
			
		}
	}
}