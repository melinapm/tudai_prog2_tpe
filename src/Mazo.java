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

	public Mazo(){
		this.cartas = new ArrayList();		
	}
	
	public void agregarCarta(Carta carta) {
		this.cartas.add(carta);
	}
	
	public Carta darUna() {
		return this.cartas.get(0);
	}
	
	public void sacarCarta(int posicion) {
		this.cartas.remove(posicion);
	}
	
	public boolean estaVacio() {
		if (tamanioMazo() != 0 )
			return true;
		else
			return false;
	}

	public void ponerCartaAlFinal(Carta carta) {
		cartas.add(tamanioMazo()+1, carta);
	}

	public int tamanioMazo() {
		if (!estaVacio())
			return cartas.size();
		else
			return 0;
	}
	
//	public Boolean cartaCorrecta(Carta carta) {
//		
//		if (!estaVacio()) {
//			if (this.cartas.get(0).cantidadAtributos() == carta.cantidadAtributos())
//				for (int i=0; i<cartas.size() ; i++) 
//					if (this.cartas.get(0).getAtributo(i))
//		
//		}
//	}
	
}
