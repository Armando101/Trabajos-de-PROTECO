public class Torres {
	
	public void Proceso(int numero, char primero, char medio, char ultimo) {
		if (numero == 1){
			System.out.println("Disco 1 desde " + primero + " a " + ultimo);
		}else {
		Proceso(numero - 1, primero, ultimo, medio);
		System.out.println("Disco " + numero + " desde " + primero + " a " + ultimo);

		Proceso(numero - 1, medio, primero, ultimo);
		System.out.println();
		}
	}
}