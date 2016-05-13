package packModelo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.CasillaMina;
import packModelo.packCasilla.CasillaVacia;
import packModelo.packCasilla.Coordenada;
import packModelo.packCasilla.Descubierta;
import packModelo.packTablero.TableroBuilderNivel1;

public class BuscaminasTest {
	private Casilla ca;
	private Coordenada co;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDesplegarCasilla() {
		//Desplegando una CasillaNumero
		co = new Coordenada(1,1);
		ca = new CasillaNumero(co);
		Buscaminas.getElBuscaminas().crearUsuario("Myke",1);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		Buscaminas.getElBuscaminas().desplegarCasilla(co);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		
		//Desplegando una CasillaMina
		co = new Coordenada(0,0);
		ca = new CasillaMina(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		Buscaminas.getElBuscaminas().desplegarCasilla(co);		
		assertTrue(Buscaminas.getElBuscaminas().hasPerdido());
		
		
		//Desplegar una casillaVacia en la esquina, rodeada de casillaNumeros
		Buscaminas.getElBuscaminas().crearUsuario("Myke",1);
		Buscaminas.getElBuscaminas().jugar();
		
		co = new Coordenada(0,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,1);
		ca = new CasillaNumero(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,0);
		ca = new CasillaNumero(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,1);
		ca = new CasillaNumero(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		
		co = new Coordenada(0,0);
		Buscaminas.getElBuscaminas().desplegarCasilla(co);
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		
		//Desplegar una casillaVacia en la esquina, rodeada de casillaVacias
		Buscaminas.getElBuscaminas().crearUsuario("Myke",1);
		Buscaminas.getElBuscaminas().jugar();
		
		co = new Coordenada(0,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		
		co = new Coordenada(0,0);
		Buscaminas.getElBuscaminas().desplegarCasilla(co);
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		
		//Desplegar una casillaVacia en el centro, rodeada de casillaVacias
		Buscaminas.getElBuscaminas().crearUsuario("Myke",1);
		Buscaminas.getElBuscaminas().jugar();
		
		co = new Coordenada(1,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,2);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,2);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(2,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(2,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(2,2);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
	
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		
		Buscaminas.getElBuscaminas().desplegarCasilla(co);
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(0,2);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(1,2);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(2,0);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(2,1);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		co = new Coordenada(2,2);
		assertTrue(Buscaminas.getElBuscaminas().estaDescubierta(co));
		
		//Intentar desplegar una casilla marcada
		Buscaminas.getElBuscaminas().crearUsuario("Myke",1);
		Buscaminas.getElBuscaminas().jugar();
		
		co = new Coordenada(1,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(0,2);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(1,2);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(2,0);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(2,1);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
		
		co = new Coordenada(2,2);
		ca = new CasillaVacia(co);
		Buscaminas.getElBuscaminas().ponerCasilla(ca);
	
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		
		co = new Coordenada(1,1);
		Buscaminas.getElBuscaminas().marcarDesmarcarCasilla(co);
		Buscaminas.getElBuscaminas().desplegarCasilla(co);
		co = new Coordenada(0,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(0,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(1,1);
		assertTrue(Buscaminas.getElBuscaminas().estaMarcada(co));
		co = new Coordenada(1,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,0);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,1);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));
		co = new Coordenada(2,2);
		assertTrue(Buscaminas.getElBuscaminas().estaCubierta(co));

	}
}
