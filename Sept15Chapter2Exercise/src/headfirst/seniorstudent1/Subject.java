/*
 * Subject.java 1.0 Sept 10, 2016
 *
 * Copyright (c) 2016 HFDP
 */
package headfirst.seniorstudent1;

public interface Subject {

  public void notifyObservers();

  public void registerObserver(Observer o);

  public void removeObserver(Observer o);
}
