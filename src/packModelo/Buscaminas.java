package packModelo;



import java.io.IOException;
import java.util.Observable;

import packModelo.packCasilla.*;
import packModelo.packCronometro.Cronometro;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilder;

public class Buscaminas extends Observable{
	private static Buscaminas elBuscaminas;
	private TableroBuilder tableroBuilder;
	private Tablero tablero;
	private boolean derrota;
	private Usuario usuario;
	private Cronometro crono;
	private int nMinasRestantes;
	
	private Buscaminas() { }
	
	public static Buscaminas getElBuscaminas() {
		if (elBuscaminas == null) elBuscaminas = new Buscaminas();
		return elBuscaminas;
	}
	
	public void setTableroBuilder(TableroBuilder pTableroBuilder) { this.tableroBuilder = pTableroBuilder; }
	
	public Tablero getTablero() { return tablero;}
	
	public void crearUsuario(String pNombre, int pNivel) {
		this.usuario = new Usuario(pNombre, pNivel);
	}
	
	public void jugar() {
		setTableroBuilder(this.usuario.getNivel());
		this.tablero = this.tableroBuilder.generarTablero();
		this.derrota = false;
		if (crono==null)this.crono = new Cronometro();
		else crono.reset();
		nMinasRestantes = tablero.getMinas();
	}
	
	public void desplegarCasilla(Coordenada pC) {
		Casilla c = tablero.desplegarCasilla(pC);
		if (c!=null && c.getEstado() instanceof Descubierta){
			setChanged();
			notifyObservers(pC);
		}
	}
	
	public void marcarDesmarcarCasilla(Coordenada pC){
		tablero.marcarDesmarcarCasilla(pC);
		setChanged();
		notifyObservers(pC);
	}
	
	public void decrementarCasillasRestantes() {
		this.tablero.decrementarCasillasRestantes();
	}
	
	public void desplegarAdyacentes(Coordenada pC){
		tablero.desplegarAdyacentes(pC);
	}

	public boolean hasGanado() {
		return this.tablero.getnCasillasRestantes() == this.tablero.getMinas();
	}
	
	public void derrotado() { this.derrota = true; }
	public boolean hasPerdido() { return this.derrota; }

	 public void guardarPuntuacion() {
		 usuario.setMinutos(crono.getMinutos());
		 usuario.setSegundos(crono.getSegundos());
		 try {
			Puntuaciones.getPuntuaciones().save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	public Cronometro getCrono(){
		return crono;
	}
	
	//Sólo para JUnits
	public void ponerCasilla(Casilla c){
		this.tablero.ponerCasilla(c);
	}

	public String tipoCasilla(Coordenada pC) {
		if (tablero.devolverCasilla(pC) instanceof CasillaMina) return "mina";
		else if (tablero.devolverCasilla(pC) instanceof CasillaNumero)
			return ((CasillaNumero) tablero.devolverCasilla(pC)).getNumero()+"";
		else return "vacia";
	}	
	public boolean estaMarcada(Coordenada pC) {
		if (tablero.devolverCasilla(pC).getEstado() instanceof Marcada) return true;
		else return false;
	}
	public boolean estaCubierta(Coordenada pC) {
		if (tablero.devolverCasilla(pC).getEstado() instanceof Cubierta) return true;
		else return false;
	}
	public boolean estaDescubierta(Coordenada pC) {
		if (tablero.devolverCasilla(pC).getEstado() instanceof Descubierta) return true;
		else return false;
	}

	public void restarMinasRestantes() {
		nMinasRestantes--;	
	}

	public void sumarMinasRestantes() {
		nMinasRestantes++;	
	}
	public String getNMinasRestantes() {
		return nMinasRestantes+"";
	}

	public void mostrarPuntuacion() {
		Puntuaciones.getPuntuaciones().imprimir();
		
	}
}
