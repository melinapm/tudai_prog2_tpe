package JuegoCartas.Febbraro.PerezMounet;

import java.util.ArrayList;

import JuegoCartas.Febbraro.PerezMounet.pocimas.Pocima;

public class Carta {
	
	private ArrayList<Atributo>atributos = new ArrayList<Atributo>();
	private String nombre;
	private Pocima pocima;
	
	
	public Carta (String nombre, ArrayList<Atributo>atributos) {
		this.nombre=nombre;
		this.atributos=atributos;
		this.pocima = null;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nuevoNombre) {
		this.nombre=nuevoNombre;
	}
	
	public ArrayList<Atributo> getAtributos(){
		return (ArrayList<Atributo>) this.atributos.clone();
	}

	public int getCantidadAtributos() {
		return this.atributos.size();
	}
	
	public Atributo getAtributoPorPosicion(int posicion) {
		Atributo atributoCopia = new Atributo(atributos.get(posicion).getNombre(), atributos.get(posicion).getValor());
		if (pocima != null) {
			atributoCopia.setValor(pocima.calcular(atributos.get(posicion)));
			return atributoCopia;
		}
		return atributos.get(posicion);
	}
	
	public Atributo getAtributoPorPosicionSinPocima(int posicion) {
		return atributos.get(posicion);
	}
	
	public Pocima getPocima() {
		return pocima;
	}

	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}	

}
