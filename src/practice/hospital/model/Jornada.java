package practice.hospital.model;

public enum Jornada {
    DIURNA(0.0),
    NOCTURNA(0.25),
    MIXTA(0.30),
    ROTATIVO(0.0);

    private final double bonoJornada;

    Jornada(double bonoJornada){
        this.bonoJornada = bonoJornada;
    }

    public double getBonoJornada(){
        return bonoJornada;
    }


}
