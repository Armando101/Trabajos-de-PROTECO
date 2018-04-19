public class Palillo {
	int n;
	boolean disp=true;

	public Palillo(int n) {
		this.n = n;
	}

	public synchronized void agarrar(int i) throws InterruptedException {
		while (!disp) {
			wait();
		System.out.println("Filosofo " + i +"agarra un palillo");
		disp = false;
		}
	}

	public synchronized void dejar(int f) throws InterruptedException {
		disp = true;
		System.out.println("Filosofo " + f + "deja el palillo");
		notify();
	}
}