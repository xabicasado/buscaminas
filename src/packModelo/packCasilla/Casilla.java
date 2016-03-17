package packModelo.packCasilla;

import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Cubierta;
import packModelo.packEstado.Estado;

public abstract class Casilla {
	private Estado estado;
	private Coordenada coordenada;
	
	public Casilla(int pFila, int pColumna){
		// TODO Completar constructor Casilla
		coordenada = new Coordenada(pFila, pColumna);
		estado = new Cubierta(coordenada);
	}
	public abstract void desplegarCasilla();
	public Coordenada getCoordenada(){return this.coordenada;}
	public void setEstado(Estado pEstado){estado=pEstado;}
	public void accionCasilla(){
		this.estado.descubrirCasilla();
	}
	
}
