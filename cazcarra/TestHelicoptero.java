
package cazcarra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pista.PistaSimple;

import avion.Helicoptero;

import copControl.Mapa;
import copControl.Posicion;

public class TestHelicoptero {

	public Helicoptero helicoptero;
	public Posicion posicion;
	public PistaSimple pista;
	
	@Before
	public void setUp() throws Exception {
		
		pista = new PistaSimple(new Posicion(10, 3));
		
		helicoptero = new Helicoptero(new Posicion(0, 1), new Posicion(2, 5), new Mapa());
		posicion = new Posicion(5, 5);
		
		//El metodo iniciarNuevaTrayectoria toma un parametro que no usa, por lo que cualquier posicion sirve.
		//Ademas, debemos ejecutarlo para cumplir con la pre-condicion de borrar la lista de destinos para que el test funcione.
		helicoptero.iniciarNuevaTrayectoria(posicion);
		helicoptero.moverHacia(posicion);
	}
	
	
	//Test unitario 1. 
	@Test
	public void testHelicopteroMoverHacia(){
		assertTrue("Failure - El objeto no se movio a la posicion indicada.", 
				(helicoptero.getDestinoActual() .getCoordenadaX()==posicion.getCoordenadaX()) &&
				(helicoptero.getDestinoActual().getCoordenadaY()==posicion.getCoordenadaY()));
	}
	
	//Test unitario 2.
	@Test
	public void testEsPosicionContenida(){
		assertTrue("Failure - La funcion 'esPosicionContenida' devolvio un resultado erroneo.", helicoptero.esPosicionContenida(posicion));
	}
	
	//Test de integracion 1.
	@Test
	public void testPuedeAterrizarHelicopteroEnPistaSimple(){
		assertFalse("Failure - Un helicoptero no deberia poder aterrizar en una pista que no sea un helipuerto.", helicoptero.puedeAterrizar(pista));
	}
	
}
