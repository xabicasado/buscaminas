package packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Puntuaciones {
	private static Puntuaciones miPuntuaciones = new Puntuaciones();
	private ArrayList<Usuario> listaUsuarios;
	
	
//Constructora
	private Puntuaciones() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}
	
	
//Otros metodos
	public static Puntuaciones getPuntuaciones() {
		return miPuntuaciones;
	}
	
	
	private Iterator<Usuario> getIterador() {
		return miPuntuaciones.listaUsuarios.iterator();
	}
	
	
	private void cargarlistaUsuarios() throws IOException {
		
		
		File f = new File("save.txt");
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader( fr );
		
		Scanner sc = new Scanner(bf);
		
		while ( sc.hasNextLine() ) {
			
			String linea = sc.nextLine();
			String[] sp = linea.split("/");
			String pNombre = sp[0];
			String [] pPuntuacion = sp[1].split(":");
			int pMinutos = Integer.parseInt(pPuntuacion[0]);
			int pSegundos = Integer.parseInt(pPuntuacion[1]);
			int pNivel = Integer.parseInt(sp[2]);
			
			Usuario unUsuario = new Usuario(pNombre, pNivel, pMinutos, pSegundos);
			miPuntuaciones.listaUsuarios.add(unUsuario);
		}
		sc.close();
		
	}
	
	
	public void guardarJugador(Usuario pUsuario ) {
		
		miPuntuaciones.listaUsuarios.add(pUsuario);
		
	}
	
	
	public void imprimir() { //TODO repensar para la vista
		try {
			Puntuaciones.getPuntuaciones().cargarlistaUsuarios();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Puntuaciones.getPuntuaciones().actualizarLista();
		
		Iterator<Usuario> itr = miPuntuaciones.getIterador();
		Usuario unJugador = null;
		int ind = 1;
		
		while ( itr.hasNext() ) {
			unJugador = itr.next();
			System.out.print("En la posicion " + ind + " esta "); unJugador.imprimirUsuario();
			ind = ind + 1;
			
		}
		
		try {
			miPuntuaciones.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		miPuntuaciones.listaUsuarios.clear();
	}
	
	
	private void actualizarLista() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		int i = 0;
		
		while ( !(miPuntuaciones.listaUsuarios.isEmpty()) && i<10 ) {
			Usuario unUsuario = miPuntuaciones.sacarLaMayorClasiDelistaUsuarios();
			lista.add(unUsuario);
			i++;
		}
		miPuntuaciones.listaUsuarios = lista;
		
	}
	
	private Usuario sacarLaMayorClasiDelistaUsuarios() {
		Iterator<Usuario> itr = miPuntuaciones.getIterador();
		Usuario c1;
		Usuario g = new Usuario("", -1);
		
		while ( itr.hasNext() ) {
			c1 = itr.next();
			
				if ( c1.getPuntuacion() > g.getPuntuacion() ) {
					g = c1;
				}
		}
		
		miPuntuaciones.listaUsuarios.remove(g);
		return g;
	}
	
	
	public void save() throws IOException {
		
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter pw = null;		
				
			f = new File( "save.txt" );
			w = new FileWriter(f);
			bw = new BufferedWriter(w);
			pw = new PrintWriter(bw);
			
			Iterator<Usuario> itr = miPuntuaciones.getIterador();
			Usuario unaClasi;
			
			while ( itr.hasNext() ) {
				unaClasi = itr.next();
				pw.write(unaClasi.getNombre()+"/"+unaClasi.getPuntuacion()+"/");
				pw.println();
			}
			
			pw.close(); 
		
	}

}
