package packModelo.packCronometro;

import packModelo.Observable;

public class Cronometro extends Observable implements Runnable {
	Thread t;
	public Cronometro() {
		t=new Thread(this, "Crono");
		t.start();
	}

	@Override
	public void run() {
		for(int i=0;;i++){
			System.out.println(""+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
