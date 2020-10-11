package JuegoCartas.Febbraro.PerezMounet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jugador maria = new Jugador("Maria");
		Jugador juan = new Jugador("Juan");

		Juego prueba = new Juego(maria, juan, "C:\\Users\\Compumar\\Documents\\Facultad\\PROG 2\\prog2-2020-TPE\\src\\JuegoCartas\\Febbraro\\PerezMounet\\superheroes.json", 50);
		
		prueba.Jugar();
	}

}
