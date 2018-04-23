public class Zoologico {
	public static void main(String[] args) {
		//Creacion de animales

		Carnivoro tigre = new Tigre("Elefantes");
		Carnivoro leon = new Leon("Caballos");
		Carnivoro puma = new Puma("Aguilas");

		Herbivoro antilope = new Antilope("Lechuga");
		Herbivoro cebra = new Cebra("Alcachofa");
		Herbivoro venado = new Venado("Hojas");

		System.out.println();

		tigre.comer();
		leon.comer(antilope);
		puma.jugar(tigre);

		antilope.comer();
		cebra.jugar();
		venado.jugar(antilope);
		
		System.out.println();
	}
}