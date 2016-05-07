package packModelo.packCasilla;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Buscaminas;
import packModelo.packTablero.TableroBuilder;
import packModelo.packTablero.TableroBuilderNivel1;

public class CubiertaTest {
private CasillaMina caM;
private CasillaNumero caN;
private CasillaVacia caV;
private Coordenada co1,co2,co3;
private Estado es1,es2,es3;
private TableroBuilder tb;

	@Before
	public void setUp() throws Exception {
		co1 = new Coordenada(1,2);
		co2 = new Coordenada(2,2);
		co3 = new Coordenada(1,3);
		caM = new CasillaMina(co1);
		caN = new CasillaNumero(co2);
		caV = new CasillaVacia(co3);
	}

	@After
	public void tearDown() throws Exception {
		co1 = new Coordenada(1,2);
		co2 = new Coordenada(2,2);
		co3 = new Coordenada(1,3);
		caM = new CasillaMina(co1);
		caN = new CasillaNumero(co2);
		caV = new CasillaVacia(co3);
	}

	@Test
	public void testDescubrirCasilla() {
		es1 = new Cubierta(co1);
		es2 = new Cubierta(co2);
		es3 = new Cubierta(co3);
		caM.setEstado(es1);
		caN.setEstado(es2);
		caV.setEstado(es3);
		tb = new TableroBuilderNivel1();
		Buscaminas.getElBuscaminas().setTableroBuilder(tb);
		Buscaminas.getElBuscaminas().jugar();
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(caM);
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(caN);
		Buscaminas.getElBuscaminas().getTablero().ponerCasilla(caV);
		assertTrue(caM.getEstado() instanceof Cubierta);
		assertTrue(caN.getEstado() instanceof Cubierta);
		assertTrue(caV.getEstado() instanceof Cubierta);
		caM.getEstado().desplegarCasilla(caM);
		caN.getEstado().desplegarCasilla(caN);
		caV.getEstado().desplegarCasilla(caV);
		assertTrue(caM.getEstado() instanceof Descubierta);
		assertTrue(caN.getEstado() instanceof Descubierta);
		assertTrue(caV.getEstado() instanceof Descubierta);
	}

}
