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

import packModelo.packTablero.*;
import packVista.vPuntuaciones;


public class Puntuaciones {
	private static Puntuaciones miPuntuaciones = new Puntuaciones();
	private ArrayList<Usuario> listaUsuarios1;
	private ArrayList<Usuario> listaUsuarios2;
	private ArrayList<Usuario> listaUsuarios3;
	
	
//Constructora
	private Puntuaciones() {
		this.listaUsuarios1 = new ArrayList<Usuario>(10);
		this.listaUsuarios2 = new ArrayList<Usuario>(10);
		this.listaUsuarios3 = new ArrayList<Usuario>(10);
	}
	
	
//Otros metodos
	public static Puntuaciones getPuntuaciones() {
		return miPuntuaciones;
	}
	
	
	private Iterator<Usuario> getIterador1() {
		return miPuntuaciones.listaUsuarios1.iterator();
	}
	
	private Iterator<Usuario> getIterador2() {
		return miPuntuaciones.listaUsuarios2.iterator();
	}
	
	private Iterator<Usuario> getIterador3() {
		return miPuntuaciones.listaUsuarios3.iterator();
	}
	
	
	public void cargarlistaUsuarios() throws IOException {
		
		
		File f = new File("save.txt");
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader( fr );
		
		
		
		Scanner sc = new Scanner(bf);
		
		while ( sc.hasNextLine() ) {
			
			String linea = sc.nextLine();
			String[] sp = linea.split("/");
			String pNombre = sp[0];
			System.out.println(sp[1]);
			String [] pPuntuacion = sp[1].split(":");
			System.out.println(pPuntuacion[0]);
			int pMinutos = Integer.parseInt(pPuntuacion[0]);
			System.out.println(pPuntuacion[1]);
			int pSegundos = Integer.parseInt(pPuntuacion[1]);
			int pNivel = Integer.parseInt(sp[2]);
			
			Usuario unUsuario = new Usuario(pNombre, pNivel, pMinutos, pSegundos);
			if (pNivel==1) miPuntuaciones.listaUsuarios1.add(unUsuario);
			else if (pNivel==2) miPuntuaciones.listaUsuarios2.add(unUsuario);
			else if (pNivel==3) miPuntuaciones.listaUsuarios3.add(unUsuario);
			
		}
		sc.close();
		
	}
	
	
	public ArrayList<String> imprimir(Usuario usuario) { //TODO repensar para la vista
		actualizarLista(usuario);
		// vPuntuaciones puntuaciones = new vPuntuaciones();
		Iterator<Usuario> itr = null;
		int niv = conseguirNivel(usuario);
		if (niv==1) {itr = miPuntuaciones.getIterador1();}
		else if (niv==2) {itr = miPuntuaciones.getIterador2();}
		else if (niv==3) {itr = miPuntuaciones.getIterador3();}

		Usuario unJugador = null;
		int ind = 1;
		ArrayList<String> listaPuntuaciones = new ArrayList<String>();
		while ( itr.hasNext() ) {
			unJugador = itr.next();
			listaPuntuaciones.add(ind + ". " + unJugador.getUsuario() + " -> " + unJugador.getPuntuacion());
			ind = ind + 1;
		}
		
		try {
			miPuntuaciones.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPuntuaciones;
	}
	
	
	private void actualizarLista(Usuario usuario) {
		int niv=conseguirNivel(usuario);
		
		Iterator<Usuario> itr = null;
		Usuario unUsuario=null;
		int i=0;
		boolean anadido=false;
		if (niv==1) {
			itr = miPuntuaciones.getIterador1();
			while (itr.hasNext() && i < 10 && !anadido){
				unUsuario=itr.next();
				if (usuario.getPuntuacionInt()<unUsuario.getPuntuacionInt()){
					if (listaUsuarios1.size()>9){
						listaUsuarios1.remove(9);
					}
					listaUsuarios1.add(i,usuario);
					anadido=true;
				}
				i++;
			}
		}
		else if (niv==2) {
			itr = miPuntuaciones.getIterador2();
			while (itr.hasNext() && i < 10){
				unUsuario=itr.next();
				if (usuario.getPuntuacionInt()>unUsuario.getPuntuacionInt()){
					if (listaUsuarios2.size()>9){
						listaUsuarios2.remove(9);
					}
					listaUsuarios2.add(i,usuario);
					anadido=true;
				}
				i++;
			}
		}
		else if (niv==3) {
			itr = miPuntuaciones.getIterador3();
			while (itr.hasNext() && i < 10){
				unUsuario=itr.next();
				if (usuario.getPuntuacionInt()>unUsuario.getPuntuacionInt()){
					if (listaUsuarios3.size()>9){
						listaUsuarios3.remove(9);
					}
					listaUsuarios3.add(i,usuario);
					anadido=true;
				}
				i++;
			}
		}
	}
	
	/*private Usuario sacarLaMayorClasiDelistaUsuarios() {
		Iterator<Usuario> itr = miPuntuaciones.getIterador();
		Usuario c1;
		Usuario g = new Usuario("", -1);
		
		while ( itr.hasNext() ) {
			c1 = itr.next();
			
				if ( c1.getPuntuacionInt() > g.getPuntuacionInt() ) {
					g = c1;
				}
		}
		
		miPuntuaciones.listaUsuarios.remove(g);
		return g;
	}*/
	
	
	public void save() throws IOException {
		
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter pw = null;		
				
			f = new File( "save.txt" );
			w = new FileWriter(f);
			bw = new BufferedWriter(w);
			pw = new PrintWriter(bw);
			
			Iterator<Usuario> itr = miPuntuaciones.getIterador1();
			Usuario u;
			while ( itr.hasNext() ) {
				u = itr.next();
				pw.write(u.getUsuario()+"/"+u.getPuntuacion()+"/"+conseguirNivel(u));
				pw.println();
			}
			itr = miPuntuaciones.getIterador2();
			while ( itr.hasNext() ) {
				u = itr.next();
				pw.write(u.getUsuario()+"/"+u.getPuntuacion()+"/"+conseguirNivel(u));
				pw.println();
			}
			itr = miPuntuaciones.getIterador3();
			while ( itr.hasNext() ) {
				u = itr.next();
				pw.write(u.getUsuario()+"/"+u.getPuntuacion()+"/"+conseguirNivel(u));
				pw.println();
			}
			
			pw.close(); 
		
	}

	private int conseguirNivel(Usuario us){
		int nivel=0;
		if (us.getNivel() instanceof TableroBuilderNivel1){
			nivel = 1;
		}else if (us.getNivel() instanceof TableroBuilderNivel2){
			nivel = 2;
		}else if (us.getNivel() instanceof TableroBuilderNivel3){
			nivel = 3;
		}
		return nivel;
	}
}
