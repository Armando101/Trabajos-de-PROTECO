public class ZoologicoMain
{
	public static void main(String[] args) 
	{
		Zoologico z = new Zoologico();
		z.agregarAnimal(new Jirafa());
		z.agregarAnimal(new Leon());
	}

	for (int i=0; i<z.numero; i++) {
		Anamal a = z.animales[i];
		a.alimentar(new Carne());
		a.alimentar(new Manzana())
		if (a instanceof Leon) {		//Verifica si a es de la clase Leon. 
			Leon l = (Leon)				//instanceof es un operador binario que devuelve un booleano
			l.rugir();					//Si a es jirafa no enstra a este codigo
		}
	}
	//Hicimos un upcast
}