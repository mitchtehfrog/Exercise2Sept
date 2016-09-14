/*
 * CurrentConditionsDisplay.java 1.0 Sep 10, 2016
 *
 * Copyright (c) 2016 HFDP and DJP
 */
package headfirst.juniorstudent2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class has data pushed to it from WeatherData. The point demonstrated here is the student has an
 * instance of this class used by another class to automatically update it when the other class has
 * determined the data has changed.
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class CurrentConditionsDisplay extends JFrame {

  private JTextField humidityTextField;
  private JTextField pressureTextField;
  private JTextField temperatureTextField;

  public CurrentConditionsDisplay(int x, int y) {
    super("Current Conditions");
    createGui();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocation(x, y);
    this.pack();
    this.setVisible(true);
  }

  public void updateData(float temperature, float humidity, float pressure) {
    temperatureTextField.setText("" + temperature);
    humidityTextField.setText("" + humidity);
    pressureTextField.setText("" + pressure);
  }

  private void createGui() {
    Container container = this.getContentPane();

    JPanel holdGrid = new JPanel();
    JPanel leftGrid = new JPanel();
    JPanel rightGrid = new JPanel();

    leftGrid.setLayout(new GridLayout(3, 1));
    leftGrid.add(new JLabel("Current Temperature ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Current Humidity ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Current Pressure ", SwingConstants.RIGHT));

    rightGrid.setLayout(new GridLayout(3, 1));
    rightGrid.add(temperatureTextField = new JTextField("0", 10));
    rightGrid.add(humidityTextField = new JTextField("0", 10));
    rightGrid.add(pressureTextField = new JTextField("0", 10));

    holdGrid.setLayout(new BorderLayout(5, 0));
    holdGrid.add(leftGrid, BorderLayout.WEST);
    holdGrid.add(rightGrid, BorderLayout.CENTER);
    container.add(holdGrid, BorderLayout.CENTER);
  }

}
