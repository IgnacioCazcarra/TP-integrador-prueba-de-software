package cazcarra;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
import avion.AvionPesado;
import avion.AvionSimple;

import copControl.Dificultad;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import static org.junit.Assert.*;


public class TestNivel {

	public Nivel nivel;
	public Mapa mapa;
	public ArrayList<Avion> aviones;
	
	
	@Before
	public void setUp() throws Exception {
		mapa = new Mapa();
		nivel = new Nivel(mapa, new Dificultad(2, 10, 1));
		
		aviones = new ArrayList<Avion>();
		aviones.add(new AvionPesado(new Posicion(1, 1), new Posicion(3, 3), mapa));
		aviones.add(new AvionSimple(new Posicion(1, 1), new Posicion(3, 3), mapa));
		
		for(Avion a: aviones){
			nivel.colocarAvionEnAire(a);
		}
	}
		
	
	//Test de integracion 3.
	@Test
	public void testGetAvionEnPosicion(){
		assertNotNull("Failure - El metodo funciona incorrectamente pues hay aviones con posicion contenida en la posicion ingresada.", nivel.getAvionEnPosicion(new Posicion(2, 2)));
	}
			
	//Test de integracion 4.
	@Test
	public void testHuboChoque(){
		assertTrue("Failure - El metodo 'huboChoque' no detecto el choque ocurrido", nivel.huboChoque());
	}

}
