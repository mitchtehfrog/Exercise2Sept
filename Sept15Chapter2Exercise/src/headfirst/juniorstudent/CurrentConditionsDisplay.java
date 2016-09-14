/*
 * CurrentConditionsDisplay.java 1.0 Sept 10, 2016
 *
 * Copyright (c) 2016 HFDP and DJP
 */
package headfirst.juniorstudent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Model the display of Current Conditions from Chapter 2 of HFDP. Trying to simulate a beginning
 * student who only has a display updated when the display requests to be updated by the pressing of
 * a Get/Pull button.
 * 
 * @author dpowell2
 * @version 1.0
 */
public class CurrentConditionsDisplay extends JFrame {

  private JButton getButton;
  private JTextField humidityTextField;
  private JTextField pressureTextField;
  private JLabel temperatureLabel;
  private JTextField temperatureTextField;

  private WeatherData weatherData;

  /**
   * 
   * Sets an internal reference to a <code>WeatherData</code> instance and sets the top left corner
   * of gui to [x,y]
   * 
   * @param weatherData <code>WeatherData</code> instance used containing temperature, presssure and
   *        humidity data
   * @param x int representing left side of Frame to be drawn
   * @param y int representing top side of Frame to be drawn
   */
  public CurrentConditionsDisplay(WeatherData weatherData, int x, int y) {
    super("Current Conditions");
    this.weatherData = weatherData;
    createGui();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocation(x, y);
    this.pack();
    this.setVisible(true);
  }

  private void createGui() {
    Container container = this.getContentPane();
    JPanel holdGrid = new JPanel();
    JPanel leftGrid = new JPanel();
    JPanel rightGrid = new JPanel();
    JPanel buttonPanel = new JPanel();

    leftGrid.setLayout(new GridLayout(3, 1));
    temperatureLabel = new JLabel("Current Temperature", SwingConstants.RIGHT);
    leftGrid.add(temperatureLabel);
    leftGrid.add(new JLabel("Current Humidity ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Current Pressure ", SwingConstants.RIGHT));

    rightGrid.setLayout(new GridLayout(3, 1));
    rightGrid.add(temperatureTextField = new JTextField("0", 10));
    rightGrid.add(humidityTextField = new JTextField("0", 10));
    rightGrid.add(pressureTextField = new JTextField("0", 10));

    buttonPanel.add(getButton = new JButton("Get/Pull"));

    holdGrid.setLayout(new BorderLayout(5, 0));
    holdGrid.add(leftGrid, BorderLayout.WEST);
    holdGrid.add(rightGrid, BorderLayout.CENTER);

    container.add(holdGrid, BorderLayout.CENTER);
    container.add(buttonPanel, BorderLayout.SOUTH);

    getButton.addActionListener(new ActionListener() {
      /**
       * Sets temperature in text fields for temperature, humidity and presssure.
       * 
       * @param e ActionEvent containing button reference clicked on.
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        temperatureTextField.setText("" + weatherData.getTemperature());
        humidityTextField.setText("" + weatherData.getHumidity());
        pressureTextField.setText("" + weatherData.getPressure());
      }
    });
  }
}
