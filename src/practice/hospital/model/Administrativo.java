package practice.hospital.model;

public class Administrativo  extends Empleado{

    public Administrativo(String nombre, double salarioBase, Jornada jornada) {
        super(nombre, salarioBase, jornada);
    }

    @Override
    public String obtenerResponsabilidades() {
        return "Administrativo";
    }

    @Override
    public double getSalarioTotal() {
        return getSalarioBase() ;
    }

    @Override
    public String toString() {
        return "ADMINISTRATIVO → " + super.toString();
    }
}
