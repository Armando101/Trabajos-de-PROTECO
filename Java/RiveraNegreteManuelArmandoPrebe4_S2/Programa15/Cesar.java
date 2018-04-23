import java.util.ArrayList;

public class Cesar {
	ArrayList<Character> cifra = new ArrayList<Character>();
	
	public void Descifrar(String palabra) {

		for(int indice=0; indice<palabra.length(); indice++)
			cifra.add(palabra.charAt(indice));
		System.out.println("\n Analizando "+cifra+" ...");
			for(int indice=0; indice<cifra.size(); indice++) {
			char aux = (char) ((int) cifra.get(indice)+3);
			cifra.set(indice,aux);
			}
		System.out.println("\n Palabra cifrada: "+cifra);	
	}

	public void Cifrar(String palabra) {
		for(int indice=0; indice<palabra.length(); indice++)
			cifra.add(palabra.charAt(indice));
		System.out.println("\n Analizando "+cifra+" ...");
		for(int indice=0; indice<cifra.size(); indice++) {
			char aux = (char) ((int) cifra.get(indice)-3);
			cifra.set(indice,aux);
		}
		System.out.println("\n Palabra descifrada: "+cifra);
	}
}