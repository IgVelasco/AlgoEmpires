package Juego;

import java.util.concurrent.ThreadLocalRandom;

public class Turno {
    private int turnoActual = 0;





//Si alguno se le ocurre mas simple
    public int empiezaJugador(){
        turnoActual =  (ThreadLocalRandom.current().nextInt(0, 2)) ;
        return turnoActual + 1;
    }




}