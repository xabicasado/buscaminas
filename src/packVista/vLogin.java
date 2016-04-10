package packVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import packModelo.Buscaminas;
import packModelo.packTablero.TableroBuilderNivel1;
import packModelo.packTablero.TableroBuilderNivel2;
import packModelo.packTablero.TableroBuilderNivel3;

public class vLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblNivel;
	private JComboBox cmbNivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			vLogin dialog = new vLogin();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vLogin() {
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNombre());
		contentPanel.add(getTxtNombre());
		contentPanel.add(getLblNivel());
		contentPanel.add(getCmbNivel());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnJugar = new JButton("Jugar");
				btnJugar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(validarDatos()) {
							switch (cmbNivel.getSelectedIndex() + 1) {
								case 1:
									Buscaminas.getElBuscaminas().setTableroBuilder(new TableroBuilderNivel1());
									break;
								case 2:
									Buscaminas.getElBuscaminas().setTableroBuilder(new TableroBuilderNivel2());
									break;
								case 3:
									Buscaminas.getElBuscaminas().setTableroBuilder(new TableroBuilderNivel3());
									break;
								default:
									//TODO Excepción Tipo de Tablero incorrecto
									break;
							}
							// TODO llamar a un vBuscaminas que imprima el tablero
							
							vBuscaminas dialog = new vBuscaminas();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setLocationRelativeTo(null);
							//dialog.setModal(true);
							dialog.setVisible(true);
						}
					}
				});
				btnJugar.setActionCommand("Jugar");
				buttonPane.add(btnJugar);
				getRootPane().setDefaultButton(btnJugar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Salir");
				buttonPane.add(btnSalir);
			}
		}
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(89, 72, 59, 14);
		}
		return lblNombre;
	}
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(158, 69, 160, 20);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	private JLabel getLblNivel() {
		if (lblNivel == null) {
			lblNivel = new JLabel("Nivel:");
			lblNivel.setBounds(89, 111, 59, 14);
		}
		return lblNivel;
	}
	private JComboBox getCmbNivel() {
		if (cmbNivel == null) {
			cmbNivel = new JComboBox();
			cmbNivel.setBounds(158, 108, 160, 20);
			rellenarComboNivel();
		}
		return cmbNivel;
	}
	
	private void rellenarComboNivel() {
		cmbNivel.addItem("Principiante");
		cmbNivel.addItem("Intermedio");
		cmbNivel.addItem("Experto");
	}
	
	private boolean validarDatos() {
		if((!txtNombre.getText().equals("")) /*&& ((cmbNivel.getSelectedIndex() + 1) > 0)*/) return true;
		JOptionPane.showMessageDialog(null, "Rellene todos los campos para comenzar a jugar!", "Alerta", JOptionPane.WARNING_MESSAGE);
		return false;
	}
}
