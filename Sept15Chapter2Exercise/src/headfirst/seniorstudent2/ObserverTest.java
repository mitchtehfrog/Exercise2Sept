package headfirst.seniorstudent2;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Observer;
import java.util.Observable;

public class ObserverTest {
	private WeatherData data;
	private Observer ob;
	
	
	@Before
	public void setUp() throws Exception {
		data = new WeatherData();
		ob = new CurrentConditionsDisplay(data, 300, 300);
	}

	@After
	public void tearDown() throws Exception {
		data = null;
		ob = null;
	}

	@Test
	public void testAddObserver() {
		data.addObserver(ob);
		int i = data.countObservers();
		assertEquals(i, 1);
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
	public void testDeleteObserver(){
		data.addObserver(ob);
		data.deleteObservers();
		int i = data.countObservers();
		assertEquals(i, 0);
	}

}
