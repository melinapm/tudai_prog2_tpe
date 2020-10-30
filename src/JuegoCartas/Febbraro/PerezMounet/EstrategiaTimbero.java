package JuegoCartas.Febbraro.PerezMounet;

import java.util.ArrayList;

public class EstrategiaTimbero extends Estrategia {

	public EstrategiaTimbero() {
		super();
	}

	@Override
	public String getAtributo(Carta carta) {
		ArrayList<Atributo> atributosCarta = new ArrayList<Atributo>(); 		
		atributosCarta = carta.getAtributos();

		int valorRandom = (int) Math.floor(Math.random()* atributosCarta.size());
		return atributosCarta.get(valorRandom).getNombre();
	}

}
