package packModelo.packCasilla;

import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Estado;

public class CasillaMina extends Casilla {

	public CasillaMina(int pFila, int pColumna) {
		super(pFila, pColumna);
	}

	@Override
	public void desplegarCasilla() {
		System.out.println("Ha finalizado el juego");

	}


}
