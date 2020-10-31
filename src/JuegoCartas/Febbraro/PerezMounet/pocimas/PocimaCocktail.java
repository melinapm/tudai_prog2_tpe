package JuegoCartas.Febbraro.PerezMounet.pocimas;

import java.util.ArrayList;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaCocktail extends Pocima {

	private ArrayList<Pocima> pocimas;
	
	public PocimaCocktail(ArrayList<Pocima> pocimas) {
		super();
		this.pocimas = new ArrayList<Pocima>();
	}

	public void agregarPocima(Pocima pocima) {
		pocimas.add(pocima);		
	}
	
	@Override
	public int calcular(Atributo atributo) {
		int totalValor=0;
		if (pocimas.size() != 0)
			for (Pocima elemento:pocimas)
				totalValor =+ elemento.calcular(atributo);
		return totalValor;
	}
}
