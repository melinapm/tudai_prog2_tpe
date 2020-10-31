package JuegoCartas.Febbraro.PerezMounet;

import JuegoCartas.Febbraro.PerezMounet.estrategias.Estrategia;
import JuegoCartas.Febbraro.PerezMounet.estrategias.EstrategiaAmbicioso;
import JuegoCartas.Febbraro.PerezMounet.estrategias.EstrategiaObstinado;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estrategia comun = new EstrategiaObstinado();
		Estrategia ambicioso = new EstrategiaAmbicioso();
		
		Jugador maria = new Jugador("Maria",comun);
		Jugador juan = new Jugador("Juan", ambicioso);

		Juego prueba = new Juego(maria, juan, "C:\\Users\\Compumar\\Documents\\- Cosas\\Facultad\\PROG 2\\prog2-2020-TPE\\src\\JuegoCartas\\Febbraro\\PerezMounet\\superheroes.json",500);
		
		prueba.Jugar();
	}
}