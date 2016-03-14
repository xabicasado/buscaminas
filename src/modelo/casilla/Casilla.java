package modelo.casilla;

public abstract class Casilla {
	private Estado estado;
	private Coordenada coordenada;
	
	public Casilla(int pFila, int pColumna){
		coordenada=new Coordenada(pFila, pColumna);
		estado=new Estado(cubierta);
	}
	public abstract void accionDescubrir();
	public abstract Coordenada getCoordenada();
	public abstract void setEstado(Estado pEstado);
	
	
	
	
	
	
	
	
	
}
