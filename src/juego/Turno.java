package juego;

import java.util.concurrent.ThreadLocalRandom;

public class Turno {
    private int turnoActual;


    //Si alguno se le ocurre mas simple
    public int primerTurno() {
        turnoActual = (ThreadLocalRandom.current().nextInt(0, 2));
        return turnoActual;
    }

    public int siguienteTurno() {
        turnoActual = (turnoActual + 1) % 2;
        return turnoActual;
    }

}