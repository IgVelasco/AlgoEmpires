package modelo.juego;

import java.util.Random;

public class Turno {
    private int turnoActual;

    public int primerTurno() {
        turnoActual = new Random().nextBoolean() ? 0 : 1;
        return turnoActual;
    }

    public int siguienteTurno() {
        turnoActual = (turnoActual + 1) % 2;
        return turnoActual;
    }

}