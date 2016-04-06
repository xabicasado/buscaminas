package packModelo.packCasilla;


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
	
	public void desplegarCasilla(){
		if(!(this.estado instanceof Descubierta)) {
			setEstado(new Descubierta(this.getCoordenada()));
			this.accionCasilla();
		}
		
	}
	
	public abstract void accionCasilla();
	
}
