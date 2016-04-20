package packModelo;

import packModelo.packCasilla.Coordenada;
import packVista.IObserver;

public abstract class IObservado {
	IObserver observador;

	public IObservado() {
	}
	public void notificar(Coordenada pC){
		observador.update(pC);
	}
	public void setObservador(IObserver pObserver){
		observador=pObserver;
	}

}
