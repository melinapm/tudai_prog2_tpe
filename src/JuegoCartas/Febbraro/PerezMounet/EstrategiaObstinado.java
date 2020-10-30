package JuegoCartas.Febbraro.PerezMounet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EstrategiaObstinado extends Estrategia {
	
	private String mismoAtributo;

	public EstrategiaObstinado() {
		super();
		this.mismoAtributo = null;
	}

	public String getMismoAtributo() {
		return mismoAtributo;
	}

	private void setMismoAtributo(String mismoAtributo) {
		this.mismoAtributo = mismoAtributo;
	}

	@Override
	public String getAtributo(Carta carta) {
		if (mismoAtributo == null) {
			setMismoAtributo(carta.getAtributoPorPosicion(0).getNombre());
			return getMismoAtributo();
		} else
			return getMismoAtributo();			
	}

}
