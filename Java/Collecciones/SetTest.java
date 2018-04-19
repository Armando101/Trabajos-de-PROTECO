import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		String [] colores = {"Rojo", "Blanco", "Verde", "Gris", "Naranja", "Blanco", "Gris"};
		List<String> lista = Arrays.asList(colores);

		System.out.printf("Lista: %s\n", lista);
		ImprimeSinDuplicados(lista);
	}

	private static void ImprimeSinDuplicados(Collection<String> valores) {

		Set<String> set = new HashSet<String>(valores);
		System.out.printf("\nSin Duplicados: ");

		for (String valor : set) {
			System.out.printf("\n%s ", valor);
		}
		System.out.println();

	}
}