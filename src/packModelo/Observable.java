package packModelo;

import packModelo.packCasilla.Coordenada;
import packVista.IObserver;

public abstract class Observable {
	IObserver observador;

	public Observable() { }
	
	public void notificar(Coordenada pC) { this.observador.update(pC); }
	
	public void setObservador(IObserver pObserver){ this.observador = pObserver; }
}
