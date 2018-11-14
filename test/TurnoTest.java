import Juego.Turno;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnoTest {

    @Test
    public void testEmpiezaJugadorEstaEnIntervalo() {
        Turno unTurno = new Turno();

      int value = unTurno.empiezaJugador();

      assert(value <= 2 && value >= 1 );

    }

}