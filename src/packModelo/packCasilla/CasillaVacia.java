package packModelo.packCasilla;

import packModelo.Buscaminas;

public class CasillaVacia extends Casilla {

	public CasillaVacia(Coordenada pCoordenada) {
		super(pCoordenada);
	}

	@Override
	protected void accionCasilla() {
		Buscaminas.getElBuscaminas().desplegarAdyacentes(this.getCoordenada());
	}
}
