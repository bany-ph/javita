package practice.hospital.model;

import practice.hospital.exceptions.UserDataInvalidException;

import java.util.Optional;

public abstract class Empleado {
    private String nombre;
    private double salarioBase;
    private Jornada jornada;

    public Empleado(String nombre, double salarioBase, Jornada jornada) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.jornada = jornada;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = Optional.of(jornada).orElseThrow(UserDataInvalidException::new);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase < 0){
            throw new UserDataInvalidException("El salario No debe de ser un numero negativo");
        }

        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.isEmpty()){
            throw new UserDataInvalidException();
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return
                "nombre : '" + nombre + '\'' +
                ", salarioBase : " + salarioBase +
                ", jornada : " + jornada + "\n";
    }

    public abstract String obtenerResponsabilidades();

    public abstract double getSalarioTotal();
}
