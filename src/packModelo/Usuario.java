package packModelo;

public class Usuario {
	private String usuario;
	private int nivel;
	private int minutos;
	private int segundos;
	
	public Usuario(String usuario, int nivel) {
		super();
		this.usuario = usuario;
		this.nivel = nivel;
		this.minutos = 0;
		this.segundos = 0;
	}

	public String getUsuario() { return usuario; }
	public void setUsuario(String usuario) { this.usuario = usuario; }
	
	public int getNivel() { return nivel; }
	public void setNivel(int nivel) { this.nivel = nivel; }
	
	public int getMinutos() { return minutos; }
	public void setMinutos(int minutos) { this.minutos = minutos; }
	
	public int getSegundos() { return segundos; }
	public void setSegundos(int segundos) { this.segundos = segundos; }	
}
