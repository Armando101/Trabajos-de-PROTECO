/**
*	@author Armando Rivera
*	
*	Este programa indica donde se localiza la nota de Do en tres instrumentos distintos
*	El metodo localizar es abstracto ya que depende el instrumento la implementacion es distinta
*/
public class Main {
	public static void main(String[] args) {
		
		Guitarra g = new Guitarra();
		Piano p = new Piano();
		Bajo b = new Bajo();

		g.Localizar();
		p.Localizar();
		b.Localizar();

	}
}