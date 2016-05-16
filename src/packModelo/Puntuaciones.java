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
	
	
	public ArrayList<String> imprimir(Usuario usuario) { 
		actualizarLista(usuario);
		Iterator<Usuario> itr = null;
		int niv = usuario.conseguirNivel();
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
		
		try {miPuntuaciones.save();}
		catch (IOException e) {e.printStackTrace();}

		return listaPuntuaciones;
	}
	
	
	private void actualizarLista(Usuario usuario) {
		int niv=usuario.conseguirNivel();
		
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
				} else if (listaUsuarios1.size()<9){
					listaUsuarios1.add(usuario);
					anadido=true;
				}
				i++;
			}
		}
		else if (niv==2) {
			itr = miPuntuaciones.getIterador2();
			while (itr.hasNext() && i < 10 && !anadido){
				unUsuario=itr.next();
				if (usuario.getPuntuacionInt()<unUsuario.getPuntuacionInt()){
					if (listaUsuarios2.size()>9){
						listaUsuarios2.remove(9);
					}
					listaUsuarios2.add(i,usuario);
					anadido=true;
				} else if (listaUsuarios2.size()<9){
					listaUsuarios2.add(usuario);
					anadido=true;
				}
				i++;
			}
		}
		else if (niv==3) {
			itr = miPuntuaciones.getIterador3();
			while (itr.hasNext() && i < 10 && !anadido){
				unUsuario=itr.next();
				if (usuario.getPuntuacionInt()<unUsuario.getPuntuacionInt()){
					if (listaUsuarios3.size()>9){
						listaUsuarios3.remove(9);
					}
					listaUsuarios3.add(i,usuario);
					anadido=true;
				} else if (listaUsuarios3.size()<9){
					listaUsuarios3.add(usuario);
					anadido=true;
				}
				i++;
			}
		}
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
			
			Iterator<Usuario> itr = miPuntuaciones.getIterador1();
			Usuario u;
			while ( itr.hasNext() ) {
				u = itr.next();
				pw.write(u.getUsuario()+"/"+u.getPuntuacion()+"/"+u.conseguirNivel());
				pw.println();
			}
			itr = miPuntuaciones.getIterador2();
			while ( itr.hasNext() ) {
				u = itr.next();
				pw.write(u.getUsuario()+"/"+u.getPuntuacion()+"/"+u.conseguirNivel());
				pw.println();
			}
			itr = miPuntuaciones.getIterador3();
			while ( itr.hasNext() ) {
				u = itr.next();
				pw.write(u.getUsuario()+"/"+u.getPuntuacion()+"/"+u.conseguirNivel());
				pw.println();
			}
			
			pw.close(); 
	}
}
