package packModelo.packCasilla;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Buscaminas;
import packModelo.packTablero.TableroBuilderNivel1;

public class CasillaVaciaTest {
private Coordenada co1,co2;
private CasillaVacia ca;
private Estado es;
private TableroBuilderNivel1 tb;
	
	@Before
	public void setUp() throws Exception {
		co1 = new Coordenada(2,2);
		ca = new CasillaVacia(co1);
	}

	@After
	public void tearDown() throws Exception {
		co1 = new Coordenada(2,2);
		ca = new CasillaVacia(co1);
	}

	@Test
	public void testSetCoordenada() {
		assertNotEquals(ca.getCoordenada(),co2);
		ca.setCoordenada(co2);
		assertEquals(ca.getCoordenada(),co2);
	}

	@Test
	public void testSetEstado() {
		assertNotEquals(ca.getEstado(),es);
		es = new Cubierta(co2);
		ca.setEstado(es);
		assertEquals(ca.getEstado(),es);
	}

	@Test
	public void testDesplegarCasilla() {
		es = new Cubierta(co1);
		ca.setEstado(es);
		tb = new TableroBuilderNivel1();
		Buscaminas.getElBuscaminas().setTableroBuilder(tb);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(ca);
		ca.desplegarCasilla();
		assertTrue(ca.getEstado() instanceof Descubierta);
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
