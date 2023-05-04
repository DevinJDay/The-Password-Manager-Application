package edu.bu.met.cs665;

import edu.bu.met.cs665.Category.*;
import edu.bu.met.cs665.EncryptionAlgorithms.*;
import edu.bu.met.cs665.Password.*;


import static org.junit.Assert.assertEquals;

public class TestNotification {
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
    @org.junit.Test
    public void testNotification1(){

        // Attach the Password object as an observer to the PasswordManager
        passwordManager.attach(password1);

        // Add the Password object to the PasswordManager
        passwordManager.addPassword(password1);

        // Notify the observers of the PasswordManager
        passwordManager.notifyObservers();

        assertEquals(1, passwordManager.getPasswords().size());
        assertEquals(1, passwordManager.getObservers().size());
    }

    @org.junit.Test
    public void testNotification2(){
        // Update the category
        category1 = CB
                .setDescription("Email accounts - updated")
                .setColor("Green")
                .build();

        //Update the password for the same website and username
        Password password3 = PB
                .setEncryptedPassword("devinIsGreat")
                .setEncryptionAlgorithm(new ShaEncryptionAlgorithm())
                .setCategory(category1)
                .build();

        // Add the Password object to the PasswordManager
        passwordManager.addPassword(password3);

        //Attach the Password object as an observer to the PasswordManager
        //Should displays "Same observer existed!!"
        passwordManager.attach(password3);


        // Notify the observers of the PasswordManager
        passwordManager.notifyObservers();
        Password testPassword = (Password) passwordManager.getObservers().get(0);
        assertEquals("Green",  testPassword.getCategory().getColor());
        assertEquals("devinIsGreat", testPassword.getEncryptedPassword());
        assertEquals(2, passwordManager.getPasswords().size());
        assertEquals(1, passwordManager.getObservers().size());
    }
}
