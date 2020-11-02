package JuegoCartas.Febbraro.PerezMounet.pocimas;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaIncrementa extends Pocima {

	private double porcentaje;
		
	public PocimaIncrementa(String nombre, double porcentaje) {
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}
	
	public int calcular (Atributo atributo) {
		return (int) (atributo.getValor()+(atributo.getValor() * porcentaje/100));
	}

}
