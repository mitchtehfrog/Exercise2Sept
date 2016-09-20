/*
 * WeatherData.java 1.0 Sept 10, 2016
 *
 * Copyright (c) 2016 HFDP and DJP
 */
package headfirst.seniorstudent2;

import java.io.Serializable;
import java.util.Observable;
import java.util.ArrayList;

/**
 * Observable (Subject) broadcasts out pressure, temperature and humidity to all Observer
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class WeatherData extends Observable implements Subject, Serializable {

  private float humidity;
  private transient ArrayList<Observer> observers;
  private float pressure;
  private float temperature;

  /**
   * Initializes empty list of Observers
   */
  public WeatherData() {
	  
  }
  
  public void measurementsChanged(){
	  setChanged();
	  notifyObservers();
  }
  
  public ArrayList<Observer> getObservers(){
	  return observers;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public float getTemperature() {
    return temperature;
  }



  /**
   * Notifies all observers that data has changed. Precondition assumed that any observer that has
   * registered will all remove itself when it no longer desires service
   */
  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.updateData(temperature, humidity, pressure);
    }
  }

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    boolean result = observers.remove(o);
    System.out.println("Observer removed success is " + result);
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  @Override
  public String toString() {
    String s = "temperature: " + temperature;
    s = s + "\n" + "humidity: " + humidity;
    s = s + "\n" + "pressure: " + pressure;
    return s;
  }
}
