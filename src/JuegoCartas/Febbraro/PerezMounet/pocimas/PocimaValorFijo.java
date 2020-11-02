package JuegoCartas.Febbraro.PerezMounet.pocimas;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaValorFijo extends Pocima {

	private int valorFijo;
	
	public PocimaValorFijo(String nombre, int valorFijo) {
		this.nombre = nombre;
		this.valorFijo = valorFijo;
	}

	public int calcular(Atributo a) {
		return valorFijo;
	}
}
