public class PruebaPersona {
	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.nombre = "Armando";
		p1.edad = 20;
		p1.peso = 80;

		p1.caminar();
		p1.dormir();


		/*
			
			Persona per;
			per = new Persona();
			per = p1;
			p1 = null;

		*/
	}
}