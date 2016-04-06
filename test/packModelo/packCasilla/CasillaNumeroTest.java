package packModelo.packCasilla;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packTablero.TableroBuilderNivel1;

public class CasillaNumeroTest {
int n1,n2;
Coordenada co1,co2;
CasillaNumero ca;
Estado es1,es2;
TableroBuilderNivel1 tb;

	@Before
	public void setUp() throws Exception {
		co1 = new Coordenada(1,2);
		co2 = new Coordenada(2,2);
		ca = new CasillaNumero(co1);		
	}

	@After
	public void tearDown() throws Exception {
		co1 = new Coordenada(1,2);
		co2 = new Coordenada(2,2);
		ca = new CasillaNumero(co1);
	}

	@Test
	public void testDesplegarCasilla() {
		es1 = new Cubierta(co1);
		es2 = new Descubierta(co1);
		ca.desplegarCasilla();
		assertEquals(ca.getEstado(),);
	}

	@Test
	public void testIncrementarNumero() {
		n1 = ca.getNumero();
		ca.incrementarNumero();
		n2 = ca.getNumero();
		assertEquals(n1+1,n2);
	}

	@Test
	public void testSetCoordenada() {
		ca.setCoordenada(co2);
		assertEquals(ca.getCoordenada(),co2);
	}


	@Test
	public void testSetEstado() {
		es1 = new Cubierta(co2);
		ca.setEstado(es1);
		assertEquals(ca.getEstado(),es1);
	}

	@Test
	public void testAccionCasilla() {
		fail("Not yet implemented");
	}

}
