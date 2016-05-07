package packModelo.packCasilla;


public abstract class Estado {
	private Coordenada coordenada;
	
	protected Estado(Coordenada pCoordenada){
		coordenada=pCoordenada;
	}
	
	public Coordenada getCoordenada(){return this.coordenada;}

	public void desplegarCasilla(Casilla pCasilla) { }

}
