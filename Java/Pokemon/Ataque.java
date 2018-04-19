public class Ataque {
	String nombre;
	int danio;
	/*
				Charmadner							Bulbasur

			Tipos de Ataques						Ataques
		1) Lanzar Fuego....... 5ps			1) Lanzar Roca............ 5ps
		2) Furia Dragon........7ps			2) Cabezazo............... 8ps
		3) Grunido.............2ps			3) Rodar.................. 4ps
		4) Humo................4ps			4) Destello............... 2ps
	*/


	Ataque(String n) {
		this.nombre=n;
	}

	public void daniar(){
		switch (nombre) {
			case "Lanzar Roca" :
			danio = 5;
			break;
			case "Cabezazo" :
			danio = 8;
			break;
			case "Rodar" :
			danio = 3;
			break;
			case "Destello" :
			danio = 4;
			break;
			case "Lanzar Fuego" :
			danio = 5;
			break;
			case "Furia Dragon" :
			danio = 7;
			break;
			case "Grunido" :
			danio = 2;
			break;
			case "Humo" :
			danio = 4;
			break;
			default :
			System.out.println("Ataque");
			break;
		
			}
	
	}

	public String getNombre() {
		return nombre;
	}

	public int getDanio() {
		return danio;
	}

}