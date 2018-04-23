import java.util.HashSet;
import java.util.Set;
public class Persona {
       String nombre,nombrem,numero;
       Mascota m;
    
    Persona(String name,String number,String namem){
        this.nombre = name;
        this.numero = number;
        this.nombrem = namem;
        Mascota m = new Mascota(namem);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getMascota() {
        return nombrem;
    }
}