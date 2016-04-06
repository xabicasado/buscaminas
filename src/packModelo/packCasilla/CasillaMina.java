package packModelo.packCasilla;


public class CasillaMina extends Casilla {

	public CasillaMina(Coordenada pCoordenada) {
		super(pCoordenada);
	}

	@Override
	public void accionCasilla() {
		System.out.println("Ha finalizado el juego");
	}
}
