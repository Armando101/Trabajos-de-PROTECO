public class AdminMaterias{
	public static void main(String[] args) {
		Materia calc = new Materia(505, "Calculo", "Garcia");
		Materia alg = new Materia();

		calc.getInformacion();
		alg.getInformacion();


		alg.setDatos(403, "Algebra", "Martinez");

		alg.getInformacion();

		

	}
}