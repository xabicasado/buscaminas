package packModelo.packCasilla;


public class CasillaNumero extends Casilla {
	
	private int numero;

	public CasillaNumero(Coordenada pCoordenada) {
		super(pCoordenada);
		this.numero = 1;
	}

	@Override
	protected void accionCasilla() { }
	
	public void incrementarNumero(){
		this.numero = this.numero+1;
	}

	public int getNumero() {
		return numero;
	}
}
