package packModelo.packCasilla;

import packModelo.Buscaminas;


public class CasillaMina extends Casilla {

	public CasillaMina(Coordenada pCoordenada) {
		super(pCoordenada);
	}

	@Override
	protected void accionCasilla() {
		Buscaminas.getElBuscaminas().derrotado();
	}
}
