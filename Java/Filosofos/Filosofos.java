public class Filosofos extends Thread {
	int n;
	Palillo rigth;
	Palillo left;

	public Filosofos(int n, Palillo left, Palillo rigth) {
		this.n = n;
		this.left = left;
		this.rigth = rigth;
	}

	@Override
	public void run(){
		while (true) {
			try {	
				left.agarrar(n);
				rigth.agarrar(n);
				System.out.println("Filosofo "+n + " comiendo....");
				left.dejar(n);
				rigth.dejar(n);
			}catch (InterruptedException e) {}
		}
	}


}