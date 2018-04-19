public class Materia {
	int clave;
	String nombre;
	String profesor;

	Materia (int c, String n, String p) {
		this.clave = c;
		this.nombre = n;
		this.profesor = p;
	}

	Materia () {
		this.clave = 0;
		this.nombre = "No Asignado";
		this.profesor = "No Asignado";
	}


	public void setDatos(int cl, String no, String pr ) {
		clave = cl;
		nombre = no;
		profesor = pr;
	}

	public int getClave () {
		return clave;
	}

	public String getNombre() {
		return nombre;
	}

	public String getProfesor() {
		return profesor;
	}


	public void getInformacion() {

		System.out.printf("\n\n\tMateria: %s \n",nombre);
		System.out.printf("\tClave: %d \n", clave);
		System.out.printf("\tProfesor: %s \n\n\n", profesor);
			
	}




}