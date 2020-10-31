package JuegoCartas.Febbraro.PerezMounet;
/** 
 * TUDAI
 * Programacion II TPE 2020
 * Juego de Cartas
 * 
 */

import java.util.ArrayList;

import JuegoCartas.Febbraro.PerezMounet.estrategias.Estrategia;

/**
 * @author 
 *
 */

public class Jugador {

	private String nombre;
	private Mazo mazoJugador;
	private Boolean ganoMano;
	private Estrategia estrategiaJugador;
	
	// Constructor de jugador
	// Inicia su mazo y asigna el nombre
	Jugador(String nombre, Estrategia estrategiaJugador) {
		this.nombre = nombre;
		this.estrategiaJugador = estrategiaJugador;
		this.mazoJugador = new Mazo();
		this.ganoMano = false;
	}

	// Get Nombre jugador
	public String getNombre() {
		return nombre;
	}
	
	// Set Nombre jugador
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Retona la primer carta del mazo del jugador 
	public Carta jugarCarta() {
		return mazoJugador.tomarCartaPorPosicion(0);
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
	public void obtenerCartaPorPosicion(int posicion) {
		mazoJugador.borrarCarta(posicion);
	}
	
	// Agrega una carta al final del mazo del jugador
	// Este metodo se llama si el jugador gano la mano
	// o si empato y se queda con la carta
	public void agregarCartaFinalMazo(Carta carta) {
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
		
	public String getEstrategiaJugador() {
			return estrategiaJugador.getNombreEstrategia();
		}

	public void setEstrategiaJugador(Estrategia estrategiaJugador) {
			this.estrategiaJugador = estrategiaJugador;
		}

	// Retorna un atributo aleatorio elejido para competir
	public String getAtributoAleatorio() {
		
		if (!mazoJugador.estaVacio()) {
			return estrategiaJugador.getAtributo(mazoJugador.tomarCartaPorPosicion(0));
		}
		
		return null;
	
	}
		
}
