package JuegoCartas.Febbraro.PerezMounet;

import java.util.ArrayList;

public class Carta {
	
	private ArrayList<Atributo>atributos = new ArrayList<Atributo>();
	private String nombre;
	
	
	public Carta (String nombre, ArrayList<Atributo>atributos) {
		this.nombre=nombre;
		this.atributos=atributos;
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
		return atributos.get(posicion);
	}
	

}
