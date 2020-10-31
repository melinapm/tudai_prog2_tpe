package JuegoCartas.Febbraro.PerezMounet.pocimas;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaAtributo extends Pocima{
	
	private String nombreAtributo;
	private double porcentaje;
		
	public PocimaAtributo(String nombreAtributo, double porcentaje) {
		super();
		this.nombreAtributo = nombreAtributo;
		this.porcentaje = porcentaje;
	}

	public int calcular (Atributo atributo) {
		if (atributo.getNombre().equals(nombreAtributo)) 
			return (int) (atributo.getValor()+(atributo.getValor()* porcentaje/100));
		return atributo.getValor();
	}
}
