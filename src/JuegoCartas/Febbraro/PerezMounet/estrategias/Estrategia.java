package JuegoCartas.Febbraro.PerezMounet.estrategias;

import JuegoCartas.Febbraro.PerezMounet.Carta;

public abstract class Estrategia {

	private String nombreEstrategia;
	
	public abstract String getAtributo(Carta carta);
	
	public String getNombreEstrategia() {
		return nombreEstrategia;
	}
	public void setNombreEstrategia(String nombreEstrategia) {
		this.nombreEstrategia = nombreEstrategia;
	}
	
	
}
