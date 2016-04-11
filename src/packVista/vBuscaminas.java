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
		int filas = Buscaminas.getElBuscaminas().getTablero().getFilas();
		int columnas = Buscaminas.getElBuscaminas().getTablero().getColumnas();
		crearTablero(filas, columnas);
	}
	
	private void crearTablero(int filas, int columnas) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(filas, columnas, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				//btn = new JButton(i +","+ j);
				Coordenada c = new Coordenada(i, j);
				btn = new JButton();
				btn.addMouseListener(new MouseListener() {
					@Override
					public void mousePressed(MouseEvent e) {
					    if(e.getButton() == MouseEvent.BUTTON1) {
					      Buscaminas.getElBuscaminas().desplegarCasilla(c.getFila(), c.getColumna());
					      Casilla casilla = Buscaminas.getElBuscaminas().devolverCasilla(c);
					      if(casilla instanceof CasillaVacia) {
					    	  btn.setText("-");
					      } else if(casilla instanceof CasillaNumero) {
					    	  btn.setText(String.valueOf(((CasillaNumero) casilla).getNumero()));
					      } else {
					    	  btn.setText("*");
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
}
