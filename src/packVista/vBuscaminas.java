package packVista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Buscaminas;
import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.CasillaVacia;
import packModelo.packCasilla.Coordenada;
import packModelo.packCasilla.Descubierta;
import packModelo.packCasilla.Marcada;

public class vBuscaminas extends JFrame {

	private JPanel contentPane;
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
		// setBounds(100, 100, 450, 300);
		setBounds(100, 100, 800, 600);
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
				Coordenada c = new Coordenada(i, j);
				btn = new JButton();
				botones[c.getFila()][c.getColumna()] = btn;
				btn.addMouseListener(new MouseListener() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (!Buscaminas.getElBuscaminas().hasPerdido()
								&& !Buscaminas.getElBuscaminas().hasGanado()) {
							if (e.getButton() == MouseEvent.BUTTON1) {
								Buscaminas.getElBuscaminas()
										.desplegarCasilla(c);
								imprimir(c);
								if (!Buscaminas.getElBuscaminas().hasPerdido()) {
									if (Buscaminas.getElBuscaminas()
											.hasGanado()) {
										JOptionPane
												.showMessageDialog(
														null,
														"Has ganado la partida!",
														"Enhorabuena",
														JOptionPane.INFORMATION_MESSAGE);
										inhabilitarTablero(panel);
									}
								} else {
									JOptionPane.showMessageDialog(null,
											"Has perdido la partida!",
											"Que pena",
											JOptionPane.ERROR_MESSAGE);
									inhabilitarTablero(panel);
								}
							} else if (e.getButton() == MouseEvent.BUTTON3) {
								if (botones[c.getFila()][c.getColumna()]
										.isEnabled() == true) {
									Buscaminas.getElBuscaminas()
											.marcarDesmarcarCasilla(c);
									Casilla casilla = Buscaminas
											.getElBuscaminas().devolverCasilla(
													c);
									if (!Buscaminas.getElBuscaminas()
											.hasPerdido()
											&& !Buscaminas.getElBuscaminas()
													.hasGanado()) {
										if (casilla.getEstado() instanceof Marcada) {
											botones[c.getFila()][c.getColumna()]
													.setText("m");
										} else {
											botones[c.getFila()][c.getColumna()]
													.setText("");
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
				});
				panel.add(btn);
			}
		}
	}

	private void imprimirAdyacentes(Coordenada pCoordenada) {
		Coordenada c2 = new Coordenada();
		c2.setFila(pCoordenada.getFila() - 1);
		c2.setColumna(pCoordenada.getColumna() - 1);
		imprimir(c2);
		c2.setFila(pCoordenada.getFila() - 1);
		c2.setColumna(pCoordenada.getColumna());
		imprimir(c2);
		c2.setFila(pCoordenada.getFila() - 1);
		c2.setColumna(pCoordenada.getColumna() + 1);
		imprimir(c2);
		c2.setFila(pCoordenada.getFila());
		c2.setColumna(pCoordenada.getColumna() + 1);
		imprimir(c2);
		c2.setFila(pCoordenada.getFila() + 1);
		c2.setColumna(pCoordenada.getColumna() + 1);
		imprimir(c2);
		c2.setFila(pCoordenada.getFila() + 1);
		c2.setColumna(pCoordenada.getColumna());
		imprimir(c2);
		c2.setFila(pCoordenada.getFila() + 1);
		c2.setColumna(pCoordenada.getColumna() - 1);
		imprimir(c2);
		c2.setFila(pCoordenada.getFila());
		c2.setColumna(pCoordenada.getColumna() - 1);
		imprimir(c2);
	}

	private void imprimir(Coordenada pC) {
		Casilla casilla;
		if (pC.getFila() >= 0 && pC.getColumna() >= 0 && pC.getFila() < filas
				&& pC.getColumna() < columnas) {
			casilla = Buscaminas.getElBuscaminas().devolverCasilla(pC);
			if (casilla.getEstado() instanceof Descubierta)
				botones[pC.getFila()][pC.getColumna()].setEnabled(false);
			if (botones[pC.getFila()][pC.getColumna()].getText().equals("")) {
				if (casilla instanceof CasillaVacia) {
					botones[pC.getFila()][pC.getColumna()].setText("-");
					imprimirAdyacentes(pC);
				} else if (casilla instanceof CasillaNumero) {
					botones[pC.getFila()][pC.getColumna()].setText(String
							.valueOf(((CasillaNumero) casilla).getNumero()));
				} else {
					botones[pC.getFila()][pC.getColumna()].setText("*");
				}
			}
		}
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
