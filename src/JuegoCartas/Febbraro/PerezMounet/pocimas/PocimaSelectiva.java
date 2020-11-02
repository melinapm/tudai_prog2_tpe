package JuegoCartas.Febbraro.PerezMounet.pocimas;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaSelectiva extends Pocima{
	
	private String nombreAtributo;
	private double porcentaje;
		
	public PocimaSelectiva(String nombre, String nombreAtributo, double porcentaje) {
		this.nombre = nombre;
		this.nombreAtributo = nombreAtributo;
		this.porcentaje = porcentaje;
	}

	public int calcular (Atributo atributo) {
		if (atributo.getNombre().equals(nombreAtributo)) 
			return (int) (atributo.getValor()+(atributo.getValor()* porcentaje/100));
		return atributo.getValor();
	}
}
