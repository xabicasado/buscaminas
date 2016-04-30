package packModelo.packCronometro;

import java.util.Observable;

public class Cronometro extends Observable implements Runnable {
	private Thread t;
	
	public Cronometro() {
		this.t = new Thread(this, "Crono");
		// this.t.start();
	}

	@Override
	public void run() {
		for(int i = 0; ; i++) {
			int j = 0;
			if(i == 60) {
				j++;
				i = 0;
			}
			System.out.println(j + ":" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }	
		}
	}
}
