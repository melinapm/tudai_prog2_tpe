package JuegoCartas.Febbraro.PerezMounet;

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
