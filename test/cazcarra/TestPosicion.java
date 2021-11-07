package cazcarra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import copControl.Posicion;

public class TestPosicion {

	public Posicion posicion, posicion2;
	
	@Before
	public void setUp() throws Exception {
		posicion = new Posicion(10, 20);
		posicion2 = new Posicion(20, 10);
	}
	
	//Test unitario 4.
	@Test
	public void testIgualA(){
		assertFalse("Failure - Las posiciones no son iguales.", posicion.igualA(posicion2));
	}
	
	//Test unitario 5.
	@Test
	public void testDistanciaHasta(){
		assertTrue("Failure - La distancia calculada por el metodo no es correcta.", 
				posicion.distanciaHasta(posicion2)==java.awt.Point.distance(posicion.getCoordenadaX(), posicion.getCoordenadaY(),
																			posicion2.getCoordenadaX(), posicion2.getCoordenadaY()));
	}

}
