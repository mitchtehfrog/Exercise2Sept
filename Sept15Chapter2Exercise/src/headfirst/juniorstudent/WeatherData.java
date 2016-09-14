/*
 * WeatherData.java 1.0 Sept 10, 2016
 *
 * Copyright (c) 2016 HFDP
 */
package headfirst.juniorstudent;

/**
 * Models the weather data object for Weather O Rama of HFDP. Currently, holds temperature, pressure
 * and humidity
 * 
 * @author dpowell2
 * @version 1.0
 */
public class WeatherData {
  private float humidity;
  private float pressure;
  private float temperature;

  /**
   * Default constructor sets temperature, presssure and humidity to 0.
   */
  public WeatherData() {
    this.setTemperature(0.0f);
    this.setHumidity(0.0f);
    this.setPressure(0.0f);
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
   * method should be called whenever the weather station gets an update to its reading for
   * temperature, pressure and humidity. When called it simply prints new values to standard out
   * 
   */
  public void measurementsChanged() {
    System.out.println(this.toString());
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.setTemperature(temperature);
    this.setHumidity(humidity);
    this.setPressure(pressure);
    measurementsChanged();
  }

  @Override
  public String toString() {
    String s = "temperature: " + temperature;
    s = s + "\n" + "humidity: " + humidity;
    s = s + "\n" + "pressure: " + pressure;
    return s;
  }

  private void setHumidity(float humidity) {
    this.humidity = humidity;
  }

  private void setPressure(float pressure) {
    this.pressure = pressure;
  }

  private void setTemperature(float temperature) {
    this.temperature = temperature;
  }
}
