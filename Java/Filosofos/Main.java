public class Main {
	public static void main(String[] args) {
		Palillo[] palillo = new Palillo[5];
		for (int i =0; i<palillo.length; i++) {
			palillo[i] = new Palillo(i);
		}

		Filosofos [] filosofo = new Filosofos[5];
		for (int i =0; i<filosofo.length; i++) {
			filosofo[i] = new Filosofos(i, palillo[i], palillo[(i+1)%5]);
		}

		for (int i = 0; i<filosofo.length; i++) {
			filosofo[i].start();
		}
	}
}