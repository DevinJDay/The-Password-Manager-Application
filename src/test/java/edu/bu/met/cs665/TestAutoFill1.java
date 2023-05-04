package edu.bu.met.cs665;

import edu.bu.met.cs665.Category.Category;
import edu.bu.met.cs665.Category.CategoryBuilder;
import edu.bu.met.cs665.EncryptionAlgorithms.AesEncryptionAlgorithm;
import edu.bu.met.cs665.EncryptionAlgorithms.ShaEncryptionAlgorithm;
import edu.bu.met.cs665.Password.Password;
import edu.bu.met.cs665.Password.PasswordBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestAutoFill1 {
    @org.junit.Test
    public void testAutoFill1(){
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




        // Update the category and password objects
        category1 = CB
                .setDescription("Email accounts - updated")
                .setColor("Green")
                .build();


        Password password3 = PB
                .setEncryptedPassword("devinIsGreat")
                .setEncryptionAlgorithm(new ShaEncryptionAlgorithm())
                .setCategory(category1)
                .build();

        passwordManager.addPassword(password3);
        passwordManager.attach(password3);




        // Notify the observers of the PasswordManager
        passwordManager.notifyObservers();

        //Generate random passwords
        Password newPassword = passwordManager.generatePassword();
        password1 = PB
                .setEncryptedPassword(newPassword.getEncryptedPassword())
                .setEncryptionAlgorithm(newPassword.getEncryptionAlgorithm())
                .build();
        passwordManager.addPassword(password1);

        // Notify the observers of the PasswordManager
        passwordManager.notifyObservers();

        // Creating new password object for another username but the same website
        Password password2 = PB
                .setUsername("Ryan@gmail.com")
                .setEncryptedPassword("RyanIsCool")
                .setEncryptionAlgorithm(new AesEncryptionAlgorithm())
                .setCategory(category1)
                .build();

        //Attach the new password2 as a new observer
        passwordManager.attach(password2);

        //Add the new password2 object to the PasswordManager
        passwordManager.addPassword(password2);


        // Notify the observers of the PasswordManager
        passwordManager.notifyObservers();

        //auto filling login credentials for ""gmail.com
        //should displays 2 passwords for 2 usernames
        passwordManager.autofillCredentials("gmail.com");
        assertEquals(4, passwordManager.getPasswords().size());
        assertEquals(2, passwordManager.getObservers().size());




    }

}
