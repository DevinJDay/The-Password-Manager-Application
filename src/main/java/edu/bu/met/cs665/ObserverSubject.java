/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: ObserverSubject.java
 * Description: ObserverSubject interface
 */
package edu.bu.met.cs665;

import edu.bu.met.cs665.Password.Observer;

public interface ObserverSubject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}