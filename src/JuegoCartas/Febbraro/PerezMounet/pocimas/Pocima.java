package JuegoCartas.Febbraro.PerezMounet.pocimas;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public abstract class Pocima {
	protected String nombre;
		
	public String getNombrePocima() {
		return nombre;
	}
		
	public abstract int calcular(Atributo atributo);
	
}