import java.util.Scanner;
public class Main {
	public static void main (String [] args) {

		PrebeMart pm = new PrebeMart();
		System.out.println("Bienvenido a PrebeMart, ingrese una opcion");
		while (true) {
			System.out.println("1) Agregar al carrito    2) Quitar del carrito    3) Ver carrito    4) Total    5) Pagar");
			Scanner op = new Scanner(System.in);
			String opcion = op.nextLine();

			switch (opcion) {
				case "1" :
				System.out.println("Ingrese un producto");
				Scanner pr = new Scanner(System.in);
				String producto = pr.nextLine();

				System.out.println("Ingrese precio");
				Scanner pre = new Scanner(System.in);
				String precio = pre.nextLine();
				double prec = Double.parseDouble(precio);
				pm.Agregar(producto, prec);
				break;

				case "2" :
				System.out.println("Ingrese un producto");
				Scanner prE = new Scanner(System.in);
				String productoE = prE.nextLine();

				pm.Eliminar(productoE);
				break;

				case "3" :
				pm.VerCarrito();
				break;

				case "4" :
					
					pm.Total();
					break;
				case "5" :
				System.out.println("Ingrese su saldo disponible");
				Scanner sd = new Scanner(System.in);
				String saldo = sd.nextLine();
				double saldodis = Double.parseDouble(saldo);

				boolean sn = pm.Pagar(saldodis);
				if (sn)
					return ;
				else {
					pm.VerCarrito();
				}

				break;

				default:
					System.out.println("Opcion invalida");
					break;
			}
		}
	}

}