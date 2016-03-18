package packModelo.packCasilla;

import packModelo.packCoordenada.Coordenada;
import packModelo.packEstado.Cubierta;
import packModelo.packEstado.Estado;

public abstract class Casilla {
	private Estado estado;
	private Coordenada coordenada;
	
	public Casilla(Coordenada pCoordenada){
		this.coordenada = pCoordenada;
		this.estado = new Cubierta(this.coordenada);
	}
	
	public Coordenada getCoordenada() { return this.coordenada; }
	public void setCoordenada(Coordenada coordenada) { this.coordenada = coordenada; }
	
	public Estado getEstado() { return estado; }
	public void setEstado(Estado pEstado) { this.estado=pEstado; }
	
	public abstract void desplegarCasilla();
	
	public void accionCasilla(){
		this.estado.descubrirCasilla();
	}
	
}
