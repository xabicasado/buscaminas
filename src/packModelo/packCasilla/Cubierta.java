package packModelo.packCasilla;

import packModelo.Buscaminas;

public class Cubierta extends Estado {

	public Cubierta(Coordenada pCoordenada) {
			super(pCoordenada);
	}
	
	
	public void desplegarCasilla(Casilla pCasilla) {
		pCasilla.setEstado(new Descubierta(pCasilla.getCoordenada()));
		Buscaminas.getElBuscaminas().decrementarCasillasRestantes();
		pCasilla.accionCasilla();
	}
}
