package packModelo.packCasilla;

<<<<<<< HEAD

=======
>>>>>>> 918dc0c70c8b3af80dd9ff8bf01a304cc4df0d49
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
	
	public Casilla desplegarCasilla(){
		this.estado.desplegarCasilla(this);
		return this;
		
	}
	public void marcarDesmarcarCasilla(){
		if(this.estado instanceof Cubierta){
			setEstado(new Marcada(this.getCoordenada()));
		}
		else if(this.estado instanceof Marcada){
			setEstado(new Cubierta(this.getCoordenada()));
		}
	}
	
	public abstract void accionCasilla();
	
}
