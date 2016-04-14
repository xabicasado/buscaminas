package packModelo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCasilla.Coordenada;
import packModelo.packCasilla.Descubierta;
import packModelo.packTablero.TableroBuilderNivel1;

public class BuscaminasTest {
	private TableroBuilderNivel1 tb;
	private Coordenada co1,co2,co3;

	@Before
	public void setUp() throws Exception {
		tb = new TableroBuilderNivel1();
		co1 = new Coordenada(5,5);
		co2 = new Coordenada(0,0);
		co3 = new Coordenada(0,6);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDesplegarCasilla() {
		Buscaminas.getElBuscaminas().setTableroBuilder(tb);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().desplegarCasilla(co1);
		assertTrue(Buscaminas.getElBuscaminas().devolverCasilla(co1).getEstado() instanceof Descubierta);
		Buscaminas.getElBuscaminas().desplegarCasilla(co2);
		assertTrue(Buscaminas.getElBuscaminas().devolverCasilla(co2).getEstado() instanceof Descubierta);
		Buscaminas.getElBuscaminas().desplegarCasilla(co3);
		assertTrue(Buscaminas.getElBuscaminas().devolverCasilla(co3).getEstado() instanceof Descubierta);
	}

	@Test
	public void testAccionCasilla() {
		fail("Not yet implemented");
	}

	@Test
	public void testDesplegarAdyacentes() {
		fail("Not yet implemented");
	}

}
