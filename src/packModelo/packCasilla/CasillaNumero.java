package packModelo.packCasilla;


public class CasillaNumero extends Casilla {
	
	private int numero;

	public CasillaNumero(Coordenada pCoordenada) {
		super(pCoordenada);
		this.numero = 1;
	}

	@Override
	public void desplegarCasilla() {
		setEstado(new Descubierta(this.getCoordenada()));
	}
	
	public void incrementarNumero(){
		this.numero = this.numero+1;
	}

	public int getNumero() {
		return numero;
	}
}
