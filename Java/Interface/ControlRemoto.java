public class ControlRemoto {
	private Encendible e1, e2;
	private Apagable a1, a2;

	public ControlRemoto (Encendible e1, Encendible e2, Apagable a1, Apagable a2) {
		this.e1 = e1;
		this.e2 = e2;
		this.a1 = a1;
		this.a2 = a2;
	}


	public void oprimirBoton1() {
		e1.encender();
	}


	public void oprimirBoton2() {
		e2.encender();
	}


	public void oprimirBoton3() {
		a1.apagar();
	}


	public void oprimirBoton4() {
		a2.apagar();
	}


}