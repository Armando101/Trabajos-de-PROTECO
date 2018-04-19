public class CampoEstatico {
	static int contador=0;

	CampoEstatico() {
		contador++;
	}

	public static void main(String[] args) {		//Es buena practica poner el main en otro archivo
		System.out.println(CampoEstatico.contador);	//Es buena practica poner CampoEstatico.contador en lugar de contador
		System.out.println(CampoEstatico.contador);	//La salida es 0 en los dos casos porque nunca se llama al constructor

		new CampoEstatico();						//se crea un objeto no referenciado, por lo tanto se llama al constructor

		System.out.println(CampoEstatico.contador);	//Aqui contador vale uno porque el constructor incrementa contador

	}



}