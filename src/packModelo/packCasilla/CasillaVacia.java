package packModelo.packCasilla;

import packModelo.Buscaminas;
import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Descubierta;

public class CasillaVacia extends Casilla {

	public CasillaVacia(Coordenada pCoordenada) {
		super(pCoordenada);
	}

	@Override
	public void desplegarCasilla() {
		setEstado(new Descubierta(this.getCoordenada()));
		Buscaminas.getElBuscaminas().desplegarAdyacentes(this.getCoordenada());
	}
}
