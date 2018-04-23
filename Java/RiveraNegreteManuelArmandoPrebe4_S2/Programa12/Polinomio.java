public class Polinomio {
	double a;
	double b;
	double c;
	public Polinomio(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double Calcula() throws ImaginarioException {
		if (b*b-4*(a)*(c)<0) {
			throw new ImaginarioException(); 
		}
		else if (b*b-4*(a)*(c)<0)
			return(-b/2*a);
		else
			return((-b + Math.sqrt(b*b-4*(a*c)))/2*a);
	}

	public double getB() {
		return b;
	}
}