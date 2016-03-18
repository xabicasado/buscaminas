package packModelo.packCasilla;

import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Cubierta;
import packModelo.packEstado.Estado;

public abstract class Casilla {
	private Estado estado;
	private Coordenada coordenada;
	
	public Casilla(int pFila, int pColumna){
		coordenada = new Coordenada(pFila, pColumna);
		estado = new Cubierta(coordenada);
	}
	
	public Coordenada getCoordenada() { return this.coordenada; }
	public void setEstado(Estado pEstado) { this.estado=pEstado; }
	
	public abstract void desplegarCasilla();
	
	public void accionCasilla(){
		this.estado.descubrirCasilla();
	}
	
}
