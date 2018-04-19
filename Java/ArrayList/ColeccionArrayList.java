import java.util.ArrayList;

public class ColeccionArrayList {
	public static void main(String[] args) {
		ArrayList<String> elementos = new ArrayList<String>();

		elementos.add("rojo");	//Agrega un elemento al arrayList
		elementos.add(0,"azul");

		for (int i=0; i < elementos.size(); i++) 
			System.out.printf("%s\n", elementos.get(i));


		elementos.remove("azul");
		elementos.remove("rojo");
		System.out.println("ArrayList modificado");
		for (int i=0; i<elementos.size(); i++) {
			System.out.printf("%s\n", elementos.get(i));
		}
		//elementos.add(5, "Hola");		//Marca error ya que nos estariamos dejando espacoios vacios en el array
	}
}
