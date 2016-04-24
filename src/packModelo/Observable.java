package packModelo;

import packModelo.packCasilla.Coordenada;
import packVista.IObserver;

public abstract class Observable {
	IObserver observador;

	public Observable() {
	}
	public void notificar(Coordenada pC, String tipo){
		observador.update(pC, tipo);
	}
	public void setObservador(IObserver pObserver){
		observador=pObserver;
	}

}
