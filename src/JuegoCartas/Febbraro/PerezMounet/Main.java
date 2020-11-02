package JuegoCartas.Febbraro.PerezMounet;

import JuegoCartas.Febbraro.PerezMounet.estrategias.Estrategia;
import JuegoCartas.Febbraro.PerezMounet.estrategias.EstrategiaAmbicioso;
import JuegoCartas.Febbraro.PerezMounet.estrategias.EstrategiaObstinado;
import JuegoCartas.Febbraro.PerezMounet.pocimas.Pocima;
import JuegoCartas.Febbraro.PerezMounet.pocimas.PocimaCocktail;
import JuegoCartas.Febbraro.PerezMounet.pocimas.PocimaIncrementa;
import JuegoCartas.Febbraro.PerezMounet.pocimas.PocimaReduce;
import JuegoCartas.Febbraro.PerezMounet.pocimas.PocimaSelectiva;
import JuegoCartas.Febbraro.PerezMounet.pocimas.PocimaValorFijo;

public class Main {

	public static void main(String[] args) {
		
		// Estrategias
		Estrategia comun = new EstrategiaObstinado();
		Estrategia ambicioso = new EstrategiaAmbicioso();
		
		// Jugadores
		Jugador maria = new Jugador("Maria",comun);
		Jugador juan = new Jugador("Juan", ambicioso);

		// Pocimas
		Pocima fortalecedora = new PocimaIncrementa("Fortalecedora", 20);
		Pocima fortalecedoraPlus = new PocimaIncrementa("Fortalecedora Plus", 50);
		Pocima kriptonita = new PocimaReduce("Kriptonita", 25);
		Pocima reductorPlomo = new PocimaReduce("Reductor de Plomo", 55);
		Pocima valeCuatro = new PocimaValorFijo("Quiero Vale Cuatro", 4);
		Pocima numeroMagico = new PocimaValorFijo("Numero Magico", 23);
		Pocima selectivaFuerza = new PocimaSelectiva("Selectiva Fuerza","fuerza",35);
		Pocima selectivaPeso = new PocimaSelectiva("Selectiva Peso","peso",43);
		
		// Pocima Cocktail
		Pocima fortalecedoraPlus2 = new PocimaIncrementa("Fortalecedora Plus 2", 50);
		Pocima kriptonita2 = new PocimaReduce("Kriptonita 2", 25);
		PocimaCocktail cocktail = new PocimaCocktail("Cocktail");
		cocktail.agregarPocima(fortalecedoraPlus2);
		cocktail.agregarPocima(kriptonita2);		

		// Juego con un maximo de 50 partidas
		//Juego juegoCartas = new Juego(maria, juan, "C:\\Users\\Compumar\\Documents\\- Cosas\\Facultad\\PROG 2\\prog2-2020-TPE\\src\\JuegoCartas\\Febbraro\\PerezMounet\\superheroes.json",50);
		Juego juegoCartas = new Juego(maria, juan, "C:\\Users\\Compumar\\Documents\\- Cosas\\Facultad\\PROG 2\\prog2-2020-TPE\\src\\JuegoCartas\\Febbraro\\PerezMounet\\autos.json",50);
		
		// Agrego pocimas
		juegoCartas.agregarPocima(fortalecedora);
		juegoCartas.agregarPocima(fortalecedoraPlus);
		juegoCartas.agregarPocima(kriptonita);
		juegoCartas.agregarPocima(reductorPlomo);
		juegoCartas.agregarPocima(valeCuatro);
		juegoCartas.agregarPocima(numeroMagico);
		juegoCartas.agregarPocima(selectivaFuerza);
		juegoCartas.agregarPocima(selectivaPeso);
		juegoCartas.agregarPocima(cocktail);
		
		// A jugar!
		juegoCartas.Jugar();
		
	}
}