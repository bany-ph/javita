package practice.hospital.utils;

public class CalcularHorasExtra {

    public static double calcularHorasExtras(int horasExtra, double saldoBase){
        /*
        * suponiendo que trabajo 8 horas diarias por 20 días y las horas extra es el 125% de su pago por hora
        * */
        double pagoPorHora = (saldoBase / 160);
        double pagoExtra = pagoPorHora * 1.25;
        return pagoExtra * horasExtra ;
    }
}
