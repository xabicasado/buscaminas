package packVista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.cCasilla;
import packModelo.Buscaminas;
import packModelo.packCasilla.CasillaMina;
import packModelo.packCasilla.Coordenada;
import packModelo.packCronometro.Cronometro;

import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class vBuscaminas extends JFrame implements Observer{

	private JPanel contentPane, panel;
	private JButton btn;
	private int filas, columnas;
	private JButton[][] botones;
	private JPanel panel_1;
	private JButton btnReiniciar;
	private JButton btnNueva;
	private JTextField txtNumMinas;
	private JTextField txtCronometro;

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
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		
		jugar();
		/* crono = new Cronometro();
		// TODO QUE VAYA EN EL MODELO */
	}
	
	private void crearTablero(int filas, int columnas) {
		if(panel != null) contentPane.remove(panel);
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
		repintar();
	}
	
	private void mostrarMinas() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Coordenada c = new Coordenada(i, j);
				if(Buscaminas.getElBuscaminas().devolverCasilla(c) instanceof CasillaMina){
					botones[c.getFila()][c.getColumna()].setText("*");
					botones[c.getFila()][c.getColumna()].setEnabled(false);
				}
			}
		}
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
				public void mouseReleased(MouseEvent arg0) { }
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					jugar();
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) { }
				
				@Override
				public void mouseEntered(MouseEvent arg0) { }
				
				@Override
				public void mouseClicked(MouseEvent arg0) { }
			});
		}
		return btnReiniciar;
	}
	private JButton getBtnNueva() {
		if (btnNueva == null) {
			btnNueva = new JButton("Nueva Partida");
			btnNueva.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) { }
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					nuevaPartida();
				}
				
				private void nuevaPartida() {
					dispose();
					vLogin dialog =new vLogin();
					dialog.setLocationRelativeTo(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) { }
				
				@Override
				public void mouseEntered(MouseEvent arg0) { }
				
				@Override
				public void mouseClicked(MouseEvent arg0) { }
			});
		}
		return btnNueva;
	}
	private JTextField getTxtNumMinas() {
		if (txtNumMinas == null) {
			txtNumMinas = new JTextField();
			txtNumMinas.setEnabled(false);
			txtNumMinas.setColumns(10);
		}
		return txtNumMinas;
	}
	private JTextField getTxtCronometro() {
		if (txtCronometro == null) {
			txtCronometro = new JTextField();
			txtCronometro.setEnabled(false);
			txtCronometro.setColumns(10);
		}
		return txtCronometro;
	}
	
	public void jugar() {
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().addObserver(this);
		filas = Buscaminas.getElBuscaminas().getTablero().getFilas();
		columnas = Buscaminas.getElBuscaminas().getTablero().getColumnas();
		crearTablero(filas, columnas);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof Buscaminas){
			
		Coordenada pC=(Coordenada) ((ArrayList<Object>) arg1).get(0);
		String texto=(String) ((ArrayList<Object>) arg1).get(1);
		if(!texto.equals("m")) {
			botones[pC.getFila()][pC.getColumna()].setEnabled(false);
			botones[pC.getFila()][pC.getColumna()].setText(texto);
		} else if(botones[pC.getFila()][pC.getColumna()].getText().equals("m")) {
				botones[pC.getFila()][pC.getColumna()].setText("");
		} else {
			botones[pC.getFila()][pC.getColumna()].setText(texto);
		}
		if (!Buscaminas.getElBuscaminas().hasPerdido()) {
			if (Buscaminas.getElBuscaminas().hasGanado()) {
				JOptionPane.showMessageDialog(null,
						"Has ganado la partida!", "Enhorabuena",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			mostrarMinas();
			JOptionPane.showMessageDialog(null,
					"Has perdido la partida!", "Que pena",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
		else{if(arg0 instanceof Cronometro){
				//TODO este es el update para el cronometro, necesitamos que muestre lo que hay en arg1
			}
		}
	}
	private void repintar(){
		this.setSize(this.getWidth()+1, this.getHeight());
		this.setSize(this.getWidth()-1, this.getHeight());
	}
}
