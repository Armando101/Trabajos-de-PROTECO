import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		double a,b,c;
		ImaginarioException iiee = new ImaginarioException();

		System.out.println("Ingrese los coeficientes de su polinomio para calcular las raices");
		while (true) {
			try{
				Scanner teclado = new Scanner(System.in);
				String aa = teclado.nextLine();
				a = Double.parseDouble(aa);		
	
				Scanner tecladob = new Scanner(System.in);
				String bb = teclado.nextLine();
				b = Double.parseDouble(bb);		
		
				Scanner tecladoc = new Scanner(System.in);
				String cc = teclado.nextLine();
				c = Double.parseDouble(cc);
				break;
			}catch(NumberFormatException nfe) {
				System.out.println("Ingrese un numero valido");
			}
		}
		Polinomio p = new Polinomio(a,b,c);		
		try {
			double r1 = p.Calcula();
			double r2 = (p.Calcula() + 2*b);
			System.out.printf("Sus raices son:\n%f    %f\n", r1,r2);
		}catch(ImaginarioException ie) {
			System.out.println(ie.getMessage());
		}


	}
}