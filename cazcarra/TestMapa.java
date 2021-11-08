package cazcarra;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaSimple;

import copControl.Mapa;
import copControl.Posicion;

import avion.AvionSimple;

public class TestMapa {

	public Mapa mapa;
	public AvionSimple avion;
	public PistaSimple pista;
	public Helipuerto helipuerto;
	public ArrayList<Pista> pistas;
	public Posicion posicionPistaAdecuada;
	
	@Before
	public void setUp() throws Exception {
		mapa = new Mapa();
		avion = new AvionSimple(new Posicion(1, 1), new Posicion(3, 4), mapa);
		helipuerto = new Helipuerto(new Posicion(2, 1));
		pista = new PistaSimple(new Posicion(4, 2));
		pistas = new ArrayList<Pista>();
		pistas.add(helipuerto);
		pistas.add(pista);
		mapa.setPistas(pistas);
		posicionPistaAdecuada = mapa.getPosPistaAdecuada(avion);
	}
	
	//Test de integracion 2.
	@Test
	public void testGetPosPistaAdecuada(){
		assertTrue("Failure - La posicion devuelta por el metodo no coincide con la unica pista valida para el avionSimple.", 
				(posicionPistaAdecuada.getCoordenadaX()==pista.getX() && posicionPistaAdecuada.getCoordenadaY()==pista.getY()));
	}

}
