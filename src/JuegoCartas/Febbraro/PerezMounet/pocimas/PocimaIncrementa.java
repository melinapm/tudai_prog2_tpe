package JuegoCartas.Febbraro.PerezMounet.pocimas;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaIncrementa extends Pocima {

	private double porcentaje;
		
	public PocimaIncrementa(double porcentaje) {
		super();
		this.porcentaje = porcentaje;
	}

	public int calcular (Atributo atributo) {
		return (atributo.getValor()+(atributo.getValor() * (int) porcentaje/100));
	}

}
