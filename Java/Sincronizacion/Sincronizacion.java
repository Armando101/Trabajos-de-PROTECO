public class Sincronizacion {
	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta(1000);

		CuentaHabitante persona1 = new CuentaHabitante("Erick", cuenta, 100);
		CuentaHabitante persona2 = new CuentaHabitante("Serj", cuenta, 50);
		CuentaHabitante persona3 = new CuentaHabitante("Patish", cuenta, 200);

		persona1.start();
		persona2.start();
		persona3.start();

	}
}