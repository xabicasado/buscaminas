package packControlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

import packModelo.Buscaminas;
import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.Coordenada;
import packModelo.packCasilla.Marcada;

public class cCasilla implements MouseListener {

	@Override
	public void mousePressed(MouseEvent e) {
		
		JButton btn = (JButton)e.getSource();
		String coor[] = btn.getName().split(",");
		Coordenada c = new Coordenada(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		
		if (!Buscaminas.getElBuscaminas().hasPerdido()
				&& !Buscaminas.getElBuscaminas().hasGanado()) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				Buscaminas.getElBuscaminas().desplegarCasilla(c);
				
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				if (botones[c.getFila()][c.getColumna()].isEnabled() == true) {
					Buscaminas.getElBuscaminas().marcarDesmarcarCasilla(c);
					Casilla casilla = Buscaminas.getElBuscaminas()
							.devolverCasilla(c);
					if (!Buscaminas.getElBuscaminas().hasPerdido()
							&& !Buscaminas.getElBuscaminas().hasGanado()) {
						if (casilla.getEstado() instanceof Marcada) {
							botones[c.getFila()][c.getColumna()].setText("m");
						} else {
							botones[c.getFila()][c.getColumna()].setText("");
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
}
