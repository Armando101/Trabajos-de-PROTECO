public class Herbivoro implements Animal {

	String nom;
	String com;
	public Herbivoro(String nom, String com){
		this.nom = nom;
		this.com = com;
	}
	public String getNombre(){
		return nom;
	}

	@Override
	public void comer() {
		System.out.println("Estoy comiendo mi comida favorita que es "+com);
	}

	@Override
	public void jugar() {
		System.out.println("Estoy jugando con mis amigos Herbivoros");
	}

	public void jugar(Herbivoro her){
		System.out.println("Estoy jugando con un "+ her.getNombre());
	}
}