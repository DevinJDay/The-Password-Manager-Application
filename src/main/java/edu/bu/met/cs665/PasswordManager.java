/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: PasswordManager.java
 * Description: ObserverSubject & Singleton implementation
 */
package edu.bu.met.cs665;


import edu.bu.met.cs665.EncryptionAlgorithms.*;
import edu.bu.met.cs665.Password.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordManager implements ObserverSubject {

    private static PasswordManager instance;
    private List<Password> passwords;
    private List<Observer> observers;



    private PasswordManager() {
        passwords = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static PasswordManager getInstance() {
        if (instance == null) {
            instance = new PasswordManager();
        }
        return instance;
    }

    public void addPassword(Password password) {
        passwords.add(password);

    }


    public List<Password> getPasswords() {
        return passwords;
    }

    public List<Observer> getObservers(){
        return  observers;
    }


    public Password generatePassword() {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 12;
        EncryptionAlgorithm algorithm = new ShaEncryptionAlgorithm();

        // implementation for generating a password
        String password = generateRandomPassword(length, charset);
        String encryptedPassword = algorithm.encrypt(password);
        return new Password("", "", encryptedPassword, algorithm, null);
    }

    private String generateRandomPassword(int length, String charset) {
        // implementation for generating a random password
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(charset.charAt(random.nextInt(charset.length())));
        }
        return sb.toString();
    }

    public void autofillCredentials(String website) {
        // implementation for autofilling login credentials
        System.out.println("Found the following credentials for " + website + "...");
        System.out.println(" ");
        for (Observer observer: observers){
            if(observer instanceof Password){
                if(website.equals(((Password) observer).getWebsite())){

                    System.out.println("Username: " + ((Password)observer).getUsername());
                    System.out.println("Password: " + ((Password)observer).getEncryptedPassword());
                    System.out.println(" ");

                }
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------");

    }

    @Override
    public void attach(Observer observer) {
        for (Observer password: observers){
            if (((Password) observer).getWebsite().equals(((Password) password).getWebsite())
                    && ((Password) observer).getUsername().equals(((Password) password).getUsername())){
                System.out.println("Same observer existed!!");
                System.out.println(" ");
                password = observer;
                return;
            }
        }

        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}

