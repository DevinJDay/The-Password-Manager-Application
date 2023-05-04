package edu.bu.met.cs665;


import edu.bu.met.cs665.Category.*;
import edu.bu.met.cs665.EncryptionAlgorithms.*;
import edu.bu.met.cs665.Password.*;


import static org.junit.Assert.*;

public class TestGeneratePassword {
    @org.junit.Test
    public void testGeneratePassword(){
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

        //Generate random passwords
        Password newPassword = passwordManager.generatePassword();
        password1 = PB
                .setEncryptedPassword(newPassword.getEncryptedPassword())
                .setEncryptionAlgorithm(newPassword.getEncryptionAlgorithm())
                .build();
        passwordManager.addPassword(password1);

        // Notify the observers of the PasswordManager
        passwordManager.notifyObservers();

        assertNotEquals("devinIsAwesome", password1.getEncryptedPassword());
        assertEquals(2, passwordManager.getPasswords().size());
        assertEquals(1, passwordManager.getObservers().size());


    }
}
