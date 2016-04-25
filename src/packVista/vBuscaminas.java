package packVista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hamcrest.core.IsEqual;

import packControlador.cCasilla;
import packModelo.Buscaminas;
import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.Coordenada;
import packModelo.packCasilla.Marcada;

public class vBuscaminas extends JFrame implements IObserver{

	private JPanel contentPane, panel;
	private JButton btn;
	private int filas, columnas;
	private JButton[][] botones;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().setObservador(this);
		filas = Buscaminas.getElBuscaminas().getTablero().getFilas();
		columnas = Buscaminas.getElBuscaminas().getTablero().getColumnas();
		crearTablero(filas, columnas);
	}

	private void crearTablero(int filas, int columnas) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(filas, columnas, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		botones = new JButton[filas][columnas];
		cCasilla cCasilla = new cCasilla();

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Coordenada c = new Coordenada(i, j);
				btn = new JButton();
				btn.setName(c.toString());
				botones[c.getFila()][c.getColumna()] = btn;
				btn.addMouseListener(cCasilla);
				panel.add(btn);
			}
		}
	}
	
	public void update(Coordenada pC, String texto){
		imprimir(pC, texto);
		if (!Buscaminas.getElBuscaminas().hasPerdido()) {
			if (Buscaminas.getElBuscaminas().hasGanado()) {
				JOptionPane.showMessageDialog(null,
						"Has ganado la partida!", "Enhorabuena",
						JOptionPane.INFORMATION_MESSAGE);
				inhabilitarTablero(panel);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Has perdido la partida!", "Que pena",
					JOptionPane.ERROR_MESSAGE);
			inhabilitarTablero(panel);
		}
	}

	private void imprimir(Coordenada pC, String texto) {
		botones[pC.getFila()][pC.getColumna()].setEnabled(false);
		botones[pC.getFila()][pC.getColumna()].setText(texto);
	}

	private void inhabilitarTablero(Container container) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(false);
			if (component instanceof Container)
				inhabilitarTablero((Container) component);
		}
	}
}
