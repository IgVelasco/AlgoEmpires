import juego.Turno;
import org.junit.Test;

public class TurnoTest {

    @Test
    public void testEmpiezaJugadorEstaEnIntervalo() {
        Turno unTurno = new Turno();

      int value = unTurno.primerTurno();

      assert(value <= 2 && value >= 1 );

    }

}