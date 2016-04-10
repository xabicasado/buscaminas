package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Ventana extends JFrame {

	private static JPanel contentPane;
	private static JPanel panel;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void crearVentana(int filas, int columnas) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					crearTablero(filas,columnas);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void crearTablero(int filas, int columnas) {
				JPanel panel = getPanel(filas, columnas);
				contentPane.add(getPanel(filas, columnas), BorderLayout.CENTER);
				JButton btn;
				for (int i = 1; i <= filas; i++) {
					for (int j = 1; j <= columnas; j++) {
						btn = new JButton(i +","+ j);
						panel.add(btn);
					}
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
	}

	private static JPanel getPanel(int m, int n) {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(m, n, 0, 0));
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
		}
		return panel_1;
	}
}
