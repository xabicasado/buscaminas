package packModelo.packCasilla;


public abstract class Estado {
	private Coordenada coordenada;
	
	protected Estado(Coordenada pCoordenada){
		coordenada=pCoordenada;
	}
	
	public void descubrirCasilla(){}
	public Coordenada getCoordenada(){return this.coordenada;}

}
