package edu.bu.met.cs665;

import static org.junit.Assert.*;
import edu.bu.met.cs665.Category.*;
import edu.bu.met.cs665.EncryptionAlgorithms.AesEncryptionAlgorithm;
import edu.bu.met.cs665.Password.*;

/**
 * Write some Unit tests for your program like the examples below.
 */

public class TestBuilders {

    public TestBuilders() {
    }



    @org.junit.Test
    public void  TestBuilders(){
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
        assertEquals("devinIsAwesome", password1.getEncryptedPassword());
        assertEquals("devindayj@gmail.com", password1.getUsername());
        assertEquals("Email accounts", password1.getCategory().getDescription());
        assertEquals("Blue", password1.getCategory().getColor());

    }








}
