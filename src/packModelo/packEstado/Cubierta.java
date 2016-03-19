package packModelo.packEstado;

import packModelo.packCoordenada.Coordenada;
import packModelo.Buscaminas;

public class Cubierta extends Estado {

	public Cubierta(Coordenada pCoordenada) {
			super(pCoordenada);
	}
	
	public void descubrirCasilla(){
		Buscaminas.desplegarCasilla(this.getCoordenada().getFila(),this.getCoordenada().getColumna());
	}

}
