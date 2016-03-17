package packModelo.packCasilla;

import packModelo.Buscaminas;
import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Descubierta;
import packModelo.packEstado.Estado;

public class CasillaVacia extends Casilla {

	public CasillaVacia(int pFila, int pColumna) {
		super(pFila, pColumna);
	}

	@Override
	public void desplegarCasilla() {
		
		setEstado(new Descubierta(this.getCoordenada()));
		Buscaminas.getElBuscaminas().getTablero().desplegarAdyacentes(this.getCoordenada().getFila(), this.getCoordenada().getColumna());
	}




}
