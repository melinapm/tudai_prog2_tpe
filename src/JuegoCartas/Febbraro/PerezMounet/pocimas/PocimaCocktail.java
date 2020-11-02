package JuegoCartas.Febbraro.PerezMounet.pocimas;

import java.util.ArrayList;

import JuegoCartas.Febbraro.PerezMounet.Atributo;

public class PocimaCocktail extends Pocima {

	private ArrayList<Pocima> pocimas;
	
	public PocimaCocktail(String nombre) {
		this.nombre = nombre;
		this.pocimas = new ArrayList<Pocima>();
	}

	public void agregarPocima(Pocima pocima) {
		pocimas.add(pocima);		
	}
	
	@Override
	public int calcular(Atributo atributo) {
		Atributo cloneAtributo = new Atributo(atributo.getNombre(), atributo.getValor());
		if (pocimas.size() != 0)
			for (Pocima elemento:pocimas)
				cloneAtributo.setValor(elemento.calcular(cloneAtributo));
		return cloneAtributo.getValor();
	}
}
