package JuegoCartas.Febbraro.PerezMounet;
/** 
 * TUDAI
 * Programacion II TPE 2020
 * Juego de Cartas
 * 
 */

/**
 * @author 
 *
 */

public class Jugador {

	private String nombre;
	private Mazo mazoJugador;
	private Boolean ganoMano;
	
	// Constructor de jugador
	// Inicia su mazo y asigna el nombre
	Jugador(String nombre) {
		this.nombre = nombre;
		this.mazoJugador = new Mazo();
	}

	// Get Nombre jugador
	public String getNombre() {
		return nombre;
	}

	// Retona la primer carta del mazo del jugador 
	public Carta jugarCarta() {
		return mazoJugador.tomarUna(0);
	}
	
	// Get para saber si gano la mano
	public Boolean getGanoMano() {
		return ganoMano;
	}
	
	// Set para saber si gano la mano
	public void setGanoMano(Boolean ganoMano) {
		this.ganoMano = ganoMano;
	}

	// Retona la carta pasada por posicion 
	public void sacarCartaMazo(int posicion) {
		mazoJugador.sacarCarta(posicion);
	}
	
	// Agrega una carta al final del mazo del jugador
	// Este metodo se llama si el jugador gano la mano
	// o si empato y se queda con la carta
	public void agregarCarta(Carta carta) {
		mazoJugador.ponerCartaAlFinal(carta);
	}
	
	// Metodo para saber si el jugador se quedo sin cartas	
	public Boolean sinCartas(){
		if (mazoJugador.estaVacio())
			return true;
		else
			return false;
	}
	
	// Retorna tamanio mazo
		public int getTamanioMazo(){
			return mazoJugador.tamanioMazo();
	}
	
	// Retorna un valor aleatorio para usar como indice en el array de Atributos para competir
	public int valorAleatorio(Carta carta) {
		int tamanioAtributos = carta.getCantidadAtributos();
		int valorRandom = (int) Math.floor(Math.random()* tamanioAtributos);
		return valorRandom;
	}
	
}
