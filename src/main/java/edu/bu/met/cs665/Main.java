/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: Main.java
 * Description: Main entry point
 */

package edu.bu.met.cs665;


import edu.bu.met.cs665.Category.Category;
import edu.bu.met.cs665.Category.CategoryBuilder;
import edu.bu.met.cs665.EncryptionAlgorithms.*;
import edu.bu.met.cs665.Password.*;


/**
 * This is the Main class.
 * Please see the comments at each section below.
 */
public class Main {

  public static void main(String[] args) {

    System.out.println(" ");

    // Create a new PasswordManager instance
    PasswordManager passwordManager = PasswordManager.getInstance();
    PasswordBuilder PB = new PasswordBuilder();
    CategoryBuilder CB = new CategoryBuilder();


    // Create a new Category using the CategoryBuilder
    Category category1 = CB
            .setName("Email")
            .setDescription("Email accounts")
            .setColor("Blue")
            .build();



    // Create a new Password using the PasswordBuilder
    Password password1 = PB
            .setWebsite("gmail.com")
            .setUsername("devindayj@gmail.com")
            .setEncryptedPassword("devinIsAwesome")
            .setEncryptionAlgorithm(new AesEncryptionAlgorithm())
            .setCategory(category1)
            .build();

    // Attach the Password object as an observer to the PasswordManager
    passwordManager.attach(password1);

    // Add the Password object to the PasswordManager
    passwordManager.addPassword(password1);

    // Notify the observers of the PasswordManager
    passwordManager.notifyObservers();


    // Create a new Category using the CategoryBuilder
    Category category2 = CB
            .setName("Email")
            .setDescription("Email accounts - new")
            .setColor("Green")
            .build();






    //Update password by generating random passwords
    Password newPassword = passwordManager.generatePassword();
    Password password3 = PB
            .setEncryptedPassword(newPassword.getEncryptedPassword())
            .setEncryptionAlgorithm(newPassword.getEncryptionAlgorithm())
            .setCategory(category2)
            .build();
    passwordManager.addPassword(password3);

    // Attach the Password object as an observer to the PasswordManager
    //expecting "Same observer existed!!"
    passwordManager.attach(password3);

    // Notify the observers of the PasswordManager
    passwordManager.notifyObservers();


    // Creating new password object for another username but the same website
    Password password2 = PB
            .setUsername("Ryan@gmail.com")
            .setEncryptedPassword("RyanIsCool")
            .setEncryptionAlgorithm(new AesEncryptionAlgorithm())
            .setCategory(category1)
            .build();

    //Add new password2 as a new observer
    passwordManager.attach(password2);
    passwordManager.addPassword(password2);


    // Creating new password object for another website
    Password password4 = PB
            .setWebsite("Yahoo.com")
            .setUsername("Ryan@yahoo.com")
            .setEncryptedPassword("RyanIsCool")
            .setEncryptionAlgorithm(new AesEncryptionAlgorithm())
            .setCategory(category1)
            .build();

    //Add new password4 as a new observer
    passwordManager.attach(password4);
    passwordManager.addPassword(password4);

    // Notify the observers of the PasswordManager
    passwordManager.notifyObservers();


    //auto filling login credentials
    passwordManager.autofillCredentials("gmail.com");
    passwordManager.autofillCredentials("Yahoo.com");



  }
}

