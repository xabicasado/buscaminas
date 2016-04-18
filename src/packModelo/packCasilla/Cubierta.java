package packModelo.packCasilla;

import packModelo.Buscaminas;

public class Cubierta extends Estado {

	public Cubierta(Coordenada pCoordenada) {
			super(pCoordenada);
	}
	
	public void descubrirCasilla(){
		
		Buscaminas.getElBuscaminas().accionCasilla(this.getCoordenada());
	}
	
	public void desplegarCasilla(Casilla pCasilla) {
		pCasilla.setEstado(new Descubierta(pCasilla.getCoordenada()));
		Buscaminas.getElBuscaminas().decrementarCasillasRestantes();
		this.descubrirCasilla();
	}

}
