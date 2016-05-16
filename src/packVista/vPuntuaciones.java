package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class vPuntuaciones extends JFrame {

	private JPanel contentPane;
	private JTextArea txaPuntuaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { }
		});
	}

	/**
	 * Create the frame.
	 */
	public vPuntuaciones(ArrayList<String> puntuaciones) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTxaPuntuaciones(), BorderLayout.CENTER);
		setVisible(true);
		mostrarPuntuaciones(puntuaciones);
	}
	
	
	private void mostrarPuntuaciones(ArrayList<String> puntuaciones){
		for(String usuario : puntuaciones) {
			txaPuntuaciones.setText(txaPuntuaciones.getText() + "\n" + usuario);
		}
	}

	private JTextArea getTxaPuntuaciones() {
		if (txaPuntuaciones == null) {
			txaPuntuaciones = new JTextArea();
		}
		return txaPuntuaciones;
	}
}
