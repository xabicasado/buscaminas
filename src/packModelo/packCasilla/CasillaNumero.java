package packModelo.packCasilla;


public class CasillaNumero extends Casilla {
	
	private int numero=1;

	public CasillaNumero(Coordenada pCoordenada) {
		super(pCoordenada);
	}

	@Override
	public void desplegarCasilla() {
		setEstado(new Descubierta(this.getCoordenada()));
	}
	
	public void incrementarNumero(){
		numero=numero+1;
	}
}
