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

import java.util.ArrayList;

public class Mazo {
	
	private ArrayList<Carta> cartas;

	// Constructor Mazo
	public Mazo(){
		this.cartas = new ArrayList<Carta>();		
	}
		
	// Metodo para agregar una carta al mazo
	public void agregarCarta(Carta carta) {
		if (cartaCorrecta(carta))
			this.cartas.add(carta);
	}
	
	// Retorna carta de la posicion que se pasa
	public Carta tomarUna(int posicion) {
		return this.cartas.get(posicion);
	}
	
	// Borra la carta de la posicion que se pase por parametro
	public void sacarCarta(int posicion) {
		this.cartas.remove(posicion);
	}
	
	// Retorna true si el mazo no esta vacio
	public boolean estaVacio() {
		if (cartas.size() != 0 )
			return false;
		else
			return true;
	}

	// La carta pasada por parametro la pone al final del mazo
	public void ponerCartaAlFinal(Carta carta) {
		if (cartas.size() == 0)
			cartas.add(0, carta);
		else
			cartas.add(tamanioMazo(), carta);
	}

	// Retorna el tamanio del mazo
	public int tamanioMazo() {
		if (!estaVacio())
			return cartas.size();
		else
			return 0;
	}

	// Ponerle protected (?)
	public void borrarMazo() {
		cartas.clear();		
	}
	
	// Compara si la carta pasada por parametro se puede agregar al mazo.
	// Metodo para validar si un mazo es correcto
	// Si el mazo no es vacio, comparo que la carta pasada por parametro
	// tenga los mismos atributos (tamaño y nombres) que una carta del mazo.
	// Se toma en cuenta que los atributos en la carta estan ordenados.
	private Boolean cartaCorrecta(Carta carta) {
		
		if (!estaVacio()) {
			// Comparo cantidad de atributos en la 1er carta y en la nueva, si son iguales sigo
			if (cartas.get(0).getCantidadAtributos() == carta.getCantidadAtributos()) {
				// Por cada nombre de atributo de carta nueva lo comparo con la carta que tengo
				for (int i=0; i < cartas.get(0).getCantidadAtributos() ; i++) 
					  if (!cartas.get(0).getAtributo(i).getNombre().equalsIgnoreCase(carta.getAtributo(i).getNombre()))
						  return false;
			} else
				return false;
		}
		
		return true;
		
	}
	
	
	
}
