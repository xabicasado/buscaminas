package packModelo.packCasilla;

import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Descubierta;
import packModelo.packEstado.Estado;

public class CasillaNumero extends Casilla {

	public CasillaNumero(int pFila, int pColumna) {
		super(pFila, pColumna);
	}

	@Override
	public void desplegarCasilla() {
		setEstado(new Descubierta(this.getCoordenada()));
	}

}
