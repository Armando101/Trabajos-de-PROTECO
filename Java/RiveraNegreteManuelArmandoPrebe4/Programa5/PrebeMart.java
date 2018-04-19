import java.util.ArrayList;
public class PrebeMart {

	ArrayList<String> productos = new ArrayList<String>();
	ArrayList<Double> precio = new ArrayList<Double>();	

	public void Agregar(String prod, double pre) {
		productos.add(prod);
		precio.add(pre);
	}

	public void Eliminar(String pro) {
		int index;
		if (productos.contains(pro)) {
			index = productos.indexOf(pro);
			productos.remove(index);
			precio.remove(index);
		}
		else {
			System.out.printf("No existe %s elemento en la lista\n\n", pro);
		}
	}

	public void VerCarrito() {

		for (int i=0; i<productos.size(); i++) {
			System.out.print(productos.get(i));
			System.out.printf(": $%.2f \n", precio.get(i));
		}
	}

	public boolean Pagar(double dinero) {

		double total = 0;

		for (int i=0; i<precio.size(); i++) {
			total+=precio.get(i);
		}

		System.out.printf("El total a pagar es de $%.2f \n", total);

		if (total < dinero) {
			System.out.printf("Su cambio es de $%.2f\n", dinero-total);
			System.out.println("Gracias por su compra");
			return true;
		}
		else {		//En este caso debera mandar llamar a la funcion Ver Carrito para que el cliente 
					//pueda ver sus productos con sus repectivos precios
					//y asi elegir cual producto dejar.
					//Despues de esto se mostrara nuevamente la lista de los productos en el carrito 
				System.out.println("Saldo insuficiente, necesita eliminar elementos");
				return false;
		}
	}

	public double Total() {

		double total = 0;

		for (int i=0; i<precio.size(); i++) {
			total+=precio.get(i);
		}
		System.out.printf("Su total a pagar es de $%.2f \n", total);
		return total;
	}

}