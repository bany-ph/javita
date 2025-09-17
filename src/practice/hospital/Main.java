package practice.hospital;

import practice.hospital.model.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        * → crear validaciones necesarias y manejarlas con try-catch
        * → hacer crud
        * */
        DecimalFormat formatter = new DecimalFormat("$#,###"); // para el salario
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Medico("Luisa", 3500000, Jornada.DIURNA, "Cirujano", 1));
        empleados.add(new Administrativo("Alfonso", 2500000, Jornada.DIURNA));
        empleados.add(new Enfermero("Bany", 1500000, Jornada.NOCTURNA));

       // empleados.forEach(System.out::print);
        empleados.forEach(empleado ->  System.out.printf("""
                         %s
                NOMBRE DEL EMPLEADO → %s
                SALARIO TOTAL → %s
                JORNADA → %s
                \n""",  empleado.obtenerResponsabilidades().toUpperCase()
                , empleado.getNombre()
                ,  formatter.format(empleado.getSalarioTotal())
                ,empleado.getJornada()));
    }
}
