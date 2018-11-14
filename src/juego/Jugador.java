package juego;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import espacio.Mapa;
import estructuras.Castillo;
import estructuras.Cuartel;
import estructuras.PlazaCentral;
import unidades.Aldeano;

import java.util.ArrayList;

public class Jugador {
    private Mapa mapa;
    private Juego juego;
    private Castillo castillo;
    private ArrayList<PlazaCentral> plazasCentrales = new ArrayList<PlazaCentral>();
    private ArrayList<Cuartel> cuarteles = new ArrayList<Cuartel>();
    private ArrayList<Aldeano> aldeanosLibres = new ArrayList<Aldeano>();
    private ArrayList<Aldeano> aldeanosOcupados = new ArrayList<Aldeano>();
    public int oro;
    public int turnoNumero;
   // private Dictionary<String Estructuras[]> Necesito estructuras para ir actualizando sus turnos de construccion

    public Jugador(Mapa mapa, int posicionCastilloHorizontal , int posicionCastilloVertical , Juego juego) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        castillo = new Castillo();
        plazasCentrales.add(new PlazaCentral());

        this.juego = juego;
        this.turnoNumero = 0;
        this.oro = 100;

        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloVertical, 4);
        mapa.colocarEstructuraEn(plazasCentrales.get(0), posicionCastilloHorizontal - 2, posicionCastilloVertical, 2);

        for (int i = 0; i < 3; i++) {
            aldeanosLibres.add(i, new Aldeano());
            mapa.colocarUnidadEn(aldeanosLibres.get(i), posicionCastilloHorizontal - 3, posicionCastilloVertical + i);
        }
    }

    public void nuevoTurno() {
        this.turnoNumero ++;

    }

    public void finalizarTurno() {
        juego.cambiarTurno();
    }
}
