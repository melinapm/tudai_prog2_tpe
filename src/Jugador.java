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
	
	// Constructor de jugador
	// Inicia su mazo y asigna el nombre
	Jugador(String nombre, Mazo mazoJugador) {
		this.nombre = nombre;
		this.mazoJugador = new Mazo();
	}

	// Get Nombre jugador
	public String getNombre() {
		return nombre;
	}

	// Set Nombre jugador
	// Ver si dejamos cambiar el nombre del jugador
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Ver si es necesario
//	public Mazo getMazoJugador() {
//		return mazoJugador;
//	}

	// Retona la primer carta del mazo del jugador 
	public Carta jugarCarta() {
		return mazoJugador.darUna();
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
	
	// Retorna un atributo aleatorio para competir
	public Atributo atributoAleatorio() {
		int valorRandom = (int) Math.floor(Math.random()*(Carta.cantidadAtributos()-0+1)+0);
		return Carta.getAtributo(valorRandom);
	}
	
}
