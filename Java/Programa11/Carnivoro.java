public class Carnivoro implements Animal {
	String nom;
	String com;
	public Carnivoro(String nom, String com){
		this.nom = nom;
		this.com = com;
	}
	public String getNombre(){
		return nom;
	}
	@Override
	public void comer() {
		System.out.println("Estoy comiendo mi comida favorita que es " + com);
	}

	@Override
	public void jugar() {
		System.out.println("Estoy jugando a las mordidas");
	}

	public void comer(Herbivoro her){
		System.out.println("Me estoy comiendo un " + her.getNombre());
	}

	public void jugar(Carnivoro car){
		System.out.println("Estoy jugando con un "+ car.getNombre());
	}
}