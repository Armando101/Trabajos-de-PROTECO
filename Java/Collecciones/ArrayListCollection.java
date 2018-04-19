import java.util.ArrayList;
import java.util.List;


public class ArrayListCollection {
	public static void main(String[] args) {
		List <String> items = new ArrayList<String>();
		
		items.add("Rojo");
		items.add(0,"Amarillo");

		System.out.println("Contenido con for: ");
		for (int i = 0; i < items.size(); i++)
			System.out.printf("\n%s\n\n", items.get(i));
		Mostrar(items, "\n Muestra el contenido de la Lista con un for-each: ");

		items.add("Verde");
		items.add("Amarillo");
		Mostrar(items, "Lista con nuevos elementos");

		items.remove("Amarillo");
		Mostrar(items, "Que queda");
		items.remove(1);
		Mostrar(items, "Borrra el segundo en la lista (Verde): ");
		System.out.printf("\"Rojo\" %s esta en la lista\n", items.contains("Rojo")? "Si" : "No");
	}

	private static void Mostrar(List<String> items, String encabezado) {
		System.out.printf("\t\t"+encabezado+"\n");
		for (String item : items)
			System.out.printf("\n%s\n", item);
		System.out.println();
	}
}