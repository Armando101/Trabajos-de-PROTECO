public class CuentaHabitante extends Thread {
	private Cuenta cuenta;
	private int retiro;
	public CuentaHabitante(String name, Cuenta cuenta, int retiro) {
		super(name);
		this.cuenta = cuenta;
		this.retiro = retiro;
	}

	@Override
	public void run() {
		while (cuenta.getSaldo() > retiro) {
			try {
				cuenta.retirar(retiro);
			}catch (InterruptedException e) {}
			System.out.printf("%s retira %d pesos y quedan %d\n", getName(), this.retiro, cuenta.getSaldo());
		}
	}

}