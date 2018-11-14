import juego.Turno;
import org.junit.Test;

public class TurnoTest {

    @Test
    public void testEmpiezaJugadorEstaEnIntervalo() {
        Turno unTurno = new Turno();

        int value = unTurno.primerTurno();

        assert(value == 1 || value == 0 );

    }


    @Test
    public void testTurnoCambiaCorrectamente() {
        Turno unTurno = new Turno();
        int turnoActual ;

        int turnoInicial = unTurno.primerTurno();

        assert(turnoInicial == 1 || turnoInicial == 0 );

        turnoActual = unTurno.siguienteTurno();

        assert (turnoInicial != turnoActual);


        turnoActual = unTurno.siguienteTurno();

        assert (turnoInicial == turnoActual);

    }
}