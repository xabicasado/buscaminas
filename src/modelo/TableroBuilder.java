package modelo;

public abstract class TableroBuilder {
	private Tablero tablero;
	
	public TableroBuilder(){}
	
	public void generarTablero(pNivel: int){}//??
	
	protected void definirFilas(){}
	protected void definirColumnas(){}
	protected void definirMinas(){}
	public void ponerMinas(){}
	public void ponerNumMinasAdyacentes(){}

}
