package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import packModelo.Buscaminas;
import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.CasillaVacia;
import packModelo.packCasilla.Coordenada;

public class vBuscaminas extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private int filas, columnas;
	private JButton [][] botones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vBuscaminas frame = new vBuscaminas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vBuscaminas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Buscaminas.getElBuscaminas().jugar();
		filas = Buscaminas.getElBuscaminas().getTablero().getFilas();
		columnas = Buscaminas.getElBuscaminas().getTablero().getColumnas();
		crearTablero(filas, columnas);
	}
	
	private void crearTablero(int filas, int columnas) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(filas, columnas, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		botones = new JButton[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				//btn = new JButton(i +","+ j);
				Coordenada c = new Coordenada(i, j);
				btn = new JButton();
				botones [c.getFila()][c.getColumna()] = btn;
				btn.addMouseListener(new MouseListener() {
					@Override
					public void mousePressed(MouseEvent e) {
					    if(e.getButton() == MouseEvent.BUTTON1) {
					      Buscaminas.getElBuscaminas().desplegarCasilla(c.getFila(), c.getColumna());
					      Casilla casilla = Buscaminas.getElBuscaminas().devolverCasilla(c);
					      if(casilla instanceof CasillaVacia) {
					    	  botones[c.getFila()][c.getColumna()].setText("-");
					    	  imprimirAdyacentes(c);
					    	  
					      } else if(casilla instanceof CasillaNumero) {
					    	  botones[c.getFila()][c.getColumna()].setText(String.valueOf(((CasillaNumero) casilla).getNumero()));
					      } else {
					    	  botones[c.getFila()][c.getColumna()].setText("*");
					      }
					    }	    
					    else if(e.getButton() == MouseEvent.BUTTON3) {
					      Buscaminas.getElBuscaminas().marcarDesmarcarCasilla(c);
					    }
					}
					
					@Override
					public void mouseReleased(MouseEvent e) { }
					@Override
					public void mouseExited(MouseEvent e) { }
					@Override
					public void mouseEntered(MouseEvent e) { }
					@Override
					public void mouseClicked(MouseEvent e) { }
				});
				panel.add(btn);
			}
		}
	}
	
	private void imprimirAdyacentes(Coordenada pCoordenada){
		Casilla casilla;
		Coordenada c2 = new Coordenada();
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna()-1);
	    c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna());
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna()+1);
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila(), pCoordenada.getColumna()+1);
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna()+1);
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna());
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna()-1);
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);	
		imprimir(casilla,c2);
		casilla = Buscaminas.getElBuscaminas().devolverCasilla(pCoordenada.getFila(), pCoordenada.getColumna()-1);
		c2.setFila(pCoordenada.getFila()-1); c2.setColumna(pCoordenada.getColumna()-1);	
		imprimir(casilla,c2);
	}
	private void imprimir(Casilla pCasilla, Coordenada pC){
		if (pC.getFila() >= 0 && pC.getColumna() >= 0 && filas < pC.getFila() && columnas < pC.getColumna()){
			if(pCasilla instanceof CasillaVacia && !(botones[pC.getFila()][pC.getColumna()].getText().equals("-"))) {
				botones[pC.getFila()][pC.getColumna()].setText("-");
		    	imprimirAdyacentes(pC);
			} else if(pCasilla instanceof CasillaNumero) {
				botones[pC.getFila()][pC.getColumna()].setText(String.valueOf(((CasillaNumero) pCasilla).getNumero()));
			}
		}
	}
}
