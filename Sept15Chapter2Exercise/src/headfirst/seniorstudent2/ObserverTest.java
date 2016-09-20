package headfirst.seniorstudent2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObserverTest {
	private WeatherData data;
	
	
	@Before
	public void setUp() throws Exception {
		data = new WeatherData();
		
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	@Test
	public void testRegisterObserver() {
		Observer o = null;
		data.registerObserver(o);
		ArrayList<Observer> observers = data.getObservers();
		assertEquals(observers.size(), 1);
	}
	
	@Test
	public void testSetMeasurements(){
		float temperature = 25;
		float humidity = 45;
		float pressure = 1;
		data.setMeasurements(temperature, humidity, pressure);
		assertEquals(data.getTemperature(), 25, 0);
		assertEquals(data.getHumidity(), 45, 0);
		assertEquals(data.getPressure(), 1, 0);
	}
	
	@Test
	public void testRemoveObserver(){
		Observer o = null;
		data.registerObserver(o);
		data.removeObserver(o);
		ArrayList<Observer> observers = data.getObservers();
		assertEquals(observers.size(), 0);
	}

}
