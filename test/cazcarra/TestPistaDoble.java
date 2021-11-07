package cazcarra;

import org.junit.Before;
import org.junit.Test;

import avion.AvionComputarizado;

import copControl.Mapa;
import copControl.Posicion;

import pista.PistaDoble;

import static org.junit.Assert.*;

public class TestPistaDoble {

	public PistaDoble pista;
	public AvionComputarizado avion;
	
	@Before
	public void setUp() throws Exception {
		pista = new PistaDoble(new Posicion(0,0));
		avion = new AvionComputarizado(new Posicion(0, 0), new Mapa());		
	}
	
	
	//Test unitario 3.
	@Test
	public void testPuedeAterrizarAvionComputarizado(){
		assertTrue("Failure - Un avion computarizado deberia poder aterrizar en una pista doble.", pista.puedeAterrizar(avion));
	}

	
	//Test de integracion 5.
	@Test
	public void testAvionComputarizadoEstaEnZonaAterrizajePistaDoble(){
		assertTrue("Failure - El metodo 'estaEnZonaAterrizaje' de la pistaDoble devolvio un resultado incorrecto.", pista.estaEnZonaAterrizaje(avion));
	}

}
