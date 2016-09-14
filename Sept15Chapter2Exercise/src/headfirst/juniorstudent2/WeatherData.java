/*
 * WeatherData.java 1.0 Sept 10, 2016
 *
 * Copyright (c) 2016 HFDP
 */
package headfirst.juniorstudent2;

/**
 * Data is pushed out to three gui instances whenever measurementsChanged is called. The three gui
 * instances are hardwired and provided at instance instantiation
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class WeatherData {

  private CurrentConditionsDisplay display1;
  private CurrentConditionsDisplay display2;
  private CurrentConditionsDisplay display3;
  private float humidity;
  private float pressure;
  private float temperature;

  public WeatherData() {
    this.setTemperature(0.0f);
    this.setHumidity(0.0f);
    this.setPressure(0.0f);
  }

  /**
   * Registers three gui instances to simulate three guis used by Weather Orama.
   * 
   * @param aDisplay1 Gui to display temp, pressure and humidity
   * @param aDisplay2 Gui to display temp, presssure and humidity
   * @param aDisplay3 Gui to display temp, presssure and humidity
   */
  public WeatherData(CurrentConditionsDisplay aDisplay1, CurrentConditionsDisplay aDisplay2,
                     CurrentConditionsDisplay aDisplay3) {
    display1 = aDisplay1;
    display2 = aDisplay2;
    display3 = aDisplay3;
  }

  public CurrentConditionsDisplay getDisplay1() {
    return display1;
  }

  public CurrentConditionsDisplay getDisplay2() {
    return display2;
  }

  public CurrentConditionsDisplay getDisplay3() {
    return display3;
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

  public void measurementsChanged() {
    display1.updateData(temperature, humidity, pressure);
    display2.updateData(temperature, humidity, pressure);
    display3.updateData(temperature, humidity, pressure);

  }

  public void setDisplay1(CurrentConditionsDisplay aDisplay1) {
    display1 = aDisplay1;
  }

  public void setDisplay2(CurrentConditionsDisplay aDisplay2) {
    display2 = aDisplay2;
  }

  public void setDisplay3(CurrentConditionsDisplay aDisplay3) {
    display3 = aDisplay3;
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
