package practice.hospital.model;


public class Enfermero extends Empleado{


    public Enfermero(String nombre, double salarioBase, Jornada jornada) {
        super(nombre, salarioBase, jornada);
    }

    @Override
    public String obtenerResponsabilidades() {
        return "Enfermero";
    }

    @Override
    public double getSalarioTotal() {
        return getSalarioBase() + (getSalarioBase() * getJornada().getBonoJornada());
    }

    @Override
    public String toString() {
        return "ENFERMERO → " + super.toString();
    }
}
