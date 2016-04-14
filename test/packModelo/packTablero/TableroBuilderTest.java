package packModelo.packTablero;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCasilla.Coordenada;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilderNivel1;

public class TableroBuilderTest {
	private Tablero tab;
	private TableroBuilderNivel1 tB;
	@Before
	public void setUp() throws Exception {
		tB = new TableroBuilderNivel1();
	}

	@After
	public void tearDown() throws Exception {
		tB = null;
		tab = null;
	}

	@Test
	public void testGenerarTablero() {
		tab = tB.generarTablero();
		for (int i = 0; i <= tab.getFilas() - 1; i++) {
			for (int j = 0; j <= tab.getColumnas() - 1; j++) {
				Coordenada c = new Coordenada(i,j);
				assertNotNull(tab.devolverCasilla(c));
			}
		}
		tab.imprimirChivato();
	}
}
