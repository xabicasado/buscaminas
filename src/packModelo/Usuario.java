package packModelo;

import packModelo.packTablero.TableroBuilder;
import packModelo.packTablero.TableroBuilderNivel1;
import packModelo.packTablero.TableroBuilderNivel2;
import packModelo.packTablero.TableroBuilderNivel3;

public class Usuario {
	private String usuario;
	private TableroBuilder nivel;
	private int minutos;
	private int segundos;
	
	public Usuario(String usuario, int nivel) {
		super();
		this.usuario = usuario;
		definirNivel(nivel);
		this.minutos = 0;
		this.segundos = 0;
	}
	
	public Usuario(String usuario, int nivel, int minutos, int segundos) {
		super();
		this.usuario = usuario;
		definirNivel(nivel);
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public String getUsuario() { return usuario; }
	public void setUsuario(String usuario) { this.usuario = usuario; }
	
	public TableroBuilder getNivel() { return nivel; }
	
	public int getMinutos() { return minutos; }
	public void setMinutos(int minutos) { this.minutos = minutos; }
	
	public int getSegundos() { return segundos; }
	public void setSegundos(int segundos) { this.segundos = segundos; }
	
	public void definirNivel(int pNivel) {
		switch (pNivel) {
			case 1:
				this.nivel = new TableroBuilderNivel1();
				break;
			case 2:
				this.nivel = new TableroBuilderNivel2();
				break;
			case 3:
				this.nivel = new TableroBuilderNivel3();
				break;
			default:
				break;
		}
	}
}
