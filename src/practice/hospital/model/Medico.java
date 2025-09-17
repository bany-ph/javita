package practice.hospital.model;

import practice.hospital.exceptions.UserDataInvalidException;
import practice.hospital.utils.CalcularHorasExtra;


public class Medico extends Empleado{
    private final static double BONO_ESPECIALIDAD = 0.25;
    private String especialidad;
    private int horasExtra;

    public Medico(String nombre, double salarioBase, Jornada jornada, String especialidad, int horasExtra) {
        super(nombre, salarioBase, jornada);
        this.especialidad = especialidad;
        this.horasExtra = horasExtra;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if(especialidad.trim().isEmpty()){
            throw new UserDataInvalidException();
        }
        this.especialidad = especialidad;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    @Override
    public double getSalarioTotal() {
        return getSalarioBase() + BONO_ESPECIALIDAD + CalcularHorasExtra.calcularHorasExtras(horasExtra,getSalarioBase());
    }

    @Override
    public String obtenerResponsabilidades() {
        return "Medico";
    }

    @Override
    public String toString() {
        return "MEDICO → " + super.toString();
    }
}
