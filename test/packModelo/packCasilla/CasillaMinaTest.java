package packModelo.packCasilla;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Buscaminas;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilderNivel1;

public class CasillaMinaTest {
private Coordenada co1,co2;
private CasillaMina ca;
private Estado es;
private TableroBuilderNivel1 tb;

	@Before
	public void setUp() throws Exception {
		co1 = new Coordenada(1,2);
		ca = new CasillaMina(co1);
	}

	@After
	public void tearDown() throws Exception {
		co1 = new Coordenada(1,2);
		ca = new CasillaMina(co1);
	}

	@Test
	public void testAccionCasilla() {
		System.out.println("/////Probando desplegarCasilla de CasillaMina/////");
		ca.accionCasilla();
		System.out.println("/////Si dice que ha finalizado el juego es correcto/////");
	}

	@Test
	public void testSetCoordenada() {
		co2 = new Coordenada(3,3);
		assertNotEquals(ca.getCoordenada(),co2);
		ca.setCoordenada(co2);
		assertEquals(ca.getCoordenada(),co2);
	}

	@Test
	public void testSetEstado() {
		es = new Cubierta(co1);
		assertNotEquals(ca.getEstado(),es);
		ca.setEstado(es);
		assertEquals(ca.getEstado(),es);
	}
	
	@Test
	public void testDesplegarCasilla() {
		System.out.println("/////Probando accionCasilla de CasillaMina/////");
		es = new Cubierta(co1);
		ca.setEstado(es);
		tb = new TableroBuilderNivel1();
		Buscaminas.getElBuscaminas().setTableroBuilder(tb);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(ca);
		ca.desplegarCasilla();
		System.out.println("/////Si dice que ha finalizado el juego es correcto/////");
	}
	
	@Test
	public void testMarcarDesmarcarCasilla() {
		es = new Marcada(co1);
		ca.setEstado(es);
		tb = new TableroBuilderNivel1();
		Buscaminas.getElBuscaminas().setTableroBuilder(tb);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(ca);
		assertTrue(ca.getEstado() instanceof Marcada);
		ca.marcarDesmarcarCasilla();
		assertTrue(ca.getEstado() instanceof Cubierta);
		ca.marcarDesmarcarCasilla();
		assertTrue(ca.getEstado() instanceof Marcada);
	}
}
