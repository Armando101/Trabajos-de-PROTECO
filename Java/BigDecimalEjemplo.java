
public class BigDecimalEjemplo {
	double unCentavo=0.01;

	public void darEjemploChafa() {
		double suma = unCentavo + unCentavo + unCentavo + unCentavo + unCentavo + unCentavo; 
		System.out.println(suma);
	}

	
	public void darEjemploChido() {
		java.math.BigDecimal otroCentavo = new java.math.BigDecimal("0.1");
		java.math.BigDecimal suma = otroCentavo.add(otroCentavo).add(otroCentavo).add(otroCentavo).add(otroCentavo).add(otroCentavo).add(otroCentavo);

		System.out.println(suma);
	}

public static void main(String[] args) {
	
		BigDecimalEjemplo ej = new BigDecimal();

		ej.darEjemploChafa();
		ej.darEjemploChido();	


}

}
