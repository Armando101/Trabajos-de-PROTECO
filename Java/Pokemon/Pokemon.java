public class Pokemon {
	String nombre;
	int vida;
	int nivel;
	String at;

	Pokemon(String nom) {	//Constructor
		this.nombre = nom;
		this.nivel = 1;		//Para esta version todos los pokemones seran de nivel 1
		switch (nom) {
			case "Bulbasur" :
			this.vida = 20;
			break;

			case "Charmander" :
			this.vida = 25;
			break;

			default :
			System.out.println("Pokemon invalido");
			break;


		}
	}

	public int NiveldeVida() {
		if(vida<=0){
			System.out.printf("\n\n %s Vida: 0 \n\n %s ha muerto\n\n", nombre, nombre);
			return 0;
		}
		else
		System.out.printf("\n %s:\n Vida: %d \n\n", nombre, vida);	
		return vida;
	}

	public boolean Vivo() {
		if (vida>=0)
			return true;
		return false;
	}

	public void modificarVida(int v) {
		vida = vida - v;
	}

	public int getVida() {
		return vida;
	}

	public String getNombre() {
		return nombre;
	}


}