package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.cCasilla;
import packModelo.Buscaminas;
import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaMina;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.Coordenada;
import packModelo.packCronometro.Cronometro;

import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class vBuscaminas extends JFrame implements Observer {

	private JPanel contentPane, panel;
	private JButton btn;
	private int filas, columnas;
	private JButton[][] botones;
	private JPanel panel_1;
	private JButton btnReiniciar;
	private JButton btnNueva;
	private JTextField txtNumMinas;
	private JTextField txtCronometro;
	private boolean mostrado;

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
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE); // TODO Parar cronometro antes de cerrar
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		mostrado = false;
		jugar();
	}

	private void crearTablero(int filas, int columnas) {
		if (panel != null)
			contentPane.remove(panel);
		panel = new JPanel();
		panel.setLayout(new GridLayout(filas, columnas, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		int ancho = filas * columnas + 250;
		int alto = ancho - filas * columnas/2;
		Dimension d = new Dimension(ancho, alto);
		this.setMinimumSize(d);
		this.setSize(d);
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
		repintar();
	}

	private void mostrarMinas() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Coordenada c = new Coordenada(i, j);
				if (Buscaminas.getElBuscaminas().devolverCasilla(c) instanceof CasillaMina)
					asignarIcono(c);
			}
		}
	}
	private void asignarIcono (Coordenada pC){
		ImageIcon imagen = null;
		Casilla casilla = Buscaminas.getElBuscaminas().devolverCasilla(pC);
		if (casilla instanceof CasillaMina) {
			imagen = new ImageIcon(getClass().getResource(
					"mina.png"));
		} else if (casilla instanceof CasillaNumero) {
			imagen = new ImageIcon(getClass().getResource(
					((CasillaNumero) casilla).getNumero() + ".png"));
		}
		if (imagen != null) {
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
					botones[pC.getFila()][pC.getColumna()].getWidth(),
					botones[pC.getFila()][pC.getColumna()].getHeight(),
					Image.SCALE_DEFAULT));
			botones[pC.getFila()][pC.getColumna()].setIcon(icono);
			botones[pC.getFila()][pC.getColumna()].setText("");
			botones[pC.getFila()][pC.getColumna()].setEnabled(false);
			botones[pC.getFila()][pC.getColumna()].setDisabledIcon(botones[pC.getFila()][pC.getColumna()].getIcon());
		}
	}
	private void marcarbtn (Coordenada pC){
		
	
		if (botones[pC.getFila()][pC.getColumna()].getIcon() == null) {
			ImageIcon imagen = null;
			Casilla casilla = Buscaminas.getElBuscaminas().devolverCasilla(pC);
			imagen = new ImageIcon(getClass().getResource("bandera.png"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
					botones[pC.getFila()][pC.getColumna()].getWidth()*3/4,
					botones[pC.getFila()][pC.getColumna()].getHeight()*3/4,
					Image.SCALE_DEFAULT));
			botones[pC.getFila()][pC.getColumna()].setIcon(icono);
		} else botones[pC.getFila()][pC.getColumna()].setIcon(null);
		
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getTxtNumMinas());
			panel_1.add(getBtnReiniciar());
			panel_1.add(getBtnNueva());
			panel_1.add(getTxtCronometro());
		}
		return panel_1;
	}

	private JButton getBtnReiniciar() {
		if (btnReiniciar == null) {
			btnReiniciar = new JButton("Reiniciar");
			btnReiniciar.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					mostrado = false;
					jugar();
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return btnReiniciar;
	}

	private JButton getBtnNueva() {
		if (btnNueva == null) {
			btnNueva = new JButton("Nueva Partida");
			btnNueva.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					nuevaPartida();
				}

				private void nuevaPartida() {
					dispose();
					vLogin dialog = new vLogin();
					dialog.setLocationRelativeTo(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return btnNueva;
	}

	private JTextField getTxtNumMinas() {
		if (txtNumMinas == null) {
			txtNumMinas = new JTextField();
			txtNumMinas.setEnabled(false);
			txtNumMinas.setColumns(3);
		}
		return txtNumMinas;
	}

	private JTextField getTxtCronometro() {
		if (txtCronometro == null) {
			txtCronometro = new JTextField();
			txtCronometro.setEnabled(false);
			txtCronometro.setColumns(3);
		}
		return txtCronometro;
	}

	public void jugar() {
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().addObserver(this);
		Buscaminas.getElBuscaminas().getCrono().addObserver(this);
		filas = Buscaminas.getElBuscaminas().getTablero().getFilas();
		columnas = Buscaminas.getElBuscaminas().getTablero().getColumnas();
		crearTablero(filas, columnas);
	}

	@Override
	public void update(Observable observador, Object parametro) {
		if (observador instanceof Buscaminas) {
			// TODO ¿No puede llegar directamente el objeto Casilla?
			Coordenada pC = (Coordenada) ((ArrayList<Object>) parametro).get(0);
			String texto = (String) ((ArrayList<Object>) parametro).get(1);
			if (!texto.equals("m")) {
				botones[pC.getFila()][pC.getColumna()].setEnabled(false);
				asignarIcono(pC);
				
			} else {
				marcarbtn(pC);
			}
			if (!Buscaminas.getElBuscaminas().hasPerdido()) {
				if (Buscaminas.getElBuscaminas().hasGanado() && !mostrado) {
					JOptionPane.showMessageDialog(null,
							"Has ganado la partida!", "Enhorabuena",
							JOptionPane.INFORMATION_MESSAGE);
					Buscaminas.getElBuscaminas().guardarPuntuacion();
					mostrado = true;
				}
			} else {
				mostrarMinas();
				JOptionPane.showMessageDialog(null, "Has perdido la partida!",
						"Que pena", JOptionPane.ERROR_MESSAGE);
			}

		} else if (observador instanceof Cronometro) {
			mostrarCronometro((String) parametro);
		}
	}

	private void mostrarCronometro(String tiempo) {
		getTxtCronometro().setText(tiempo);
	}

	private void repintar() {
		this.setSize(this.getWidth() + 1, this.getHeight());
		this.setSize(this.getWidth() - 1, this.getHeight());
	}
}
