package modelo;

public class CasillaFactory {
	
	private CasillaFactory miCasillaFactory;

	private CasillaFactory() {
		miCasillaFactory=new CasillaFactory();
		// TODO Auto-generated constructor stub
	}
	
	public CasillaFactory getCasillaFactory(){return miCasillaFactory;}
	public Casilla generarCasilla(pTipo String){}

}
