package packModelo.packTablero;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Buscaminas;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.Coordenada;

public class TableroTest {
private TableroBuilderNivel1 tb;
private CasillaNumero caM,caN,caV;
private Coordenada co1,co2,co3;

		
	@Before
	public void setUp() throws Exception {
		co1 = new Coordenada(2,2);
		co2 = new Coordenada(3,2);
		co3 = new Coordenada(2,3);
		caM = new CasillaNumero(co1);
		caN = new CasillaNumero(co2);
		caV = new CasillaNumero(co3);
	}

	@After
	public void tearDown() throws Exception {
		co1 = new Coordenada(2,2);
		co2 = new Coordenada(3,2);
		co3 = new Coordenada(2,3);
		caM = new CasillaNumero(co1);
		caN = new CasillaNumero(co2);
		caV = new CasillaNumero(co3);
	}

	@Test
	public void testPonerCasilla() {
		tb = new TableroBuilderNivel1();
		Buscaminas.getElBuscaminas().setTableroBuilder(tb);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(caM);
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(caN);
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(caV);
		assertEquals(Buscaminas.getElBuscaminas().getTablero().devolverCasilla(co1),caM);
		assertEquals(Buscaminas.getElBuscaminas().getTablero().devolverCasilla(co2),caN);
		assertEquals(Buscaminas.getElBuscaminas().getTablero().devolverCasilla(co3),caV);
	}

	@Test
	public void testDesplegarAdyacentes() {
		fail("Not yet implemented");
	}
}
