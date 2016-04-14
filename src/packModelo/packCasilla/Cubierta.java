package packModelo.packCasilla;

import packModelo.Buscaminas;

public class Cubierta extends Estado {

	public Cubierta(Coordenada pCoordenada) {
			super(pCoordenada);
	}
	
	public void descubrirCasilla(){
		Buscaminas.getElBuscaminas().desplegarCasilla(this.getCoordenada());
	}

}
