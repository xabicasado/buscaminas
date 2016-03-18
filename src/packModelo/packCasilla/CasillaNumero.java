package packModelo.packCasilla;

import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Descubierta;

public class CasillaNumero extends Casilla {

	public CasillaNumero(Coordenada pCoordenada) {
		super(pCoordenada);
	}

	@Override
	public void desplegarCasilla() {
		setEstado(new Descubierta(this.getCoordenada()));
	}

}
