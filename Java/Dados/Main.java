public class Main {
	public static void main(String[] args) {
		Dados d1 = new Dados();
		int [] b =new int[12];
		int [] a = new int[1100];

		a=d1.tirar(1100);
		b=d1.ordenar(a);
		d1.imprimir(b);
	}
}