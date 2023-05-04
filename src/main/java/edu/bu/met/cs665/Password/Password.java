/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: Password.java
 * Description: Observer and Builder implementation
 */
package edu.bu.met.cs665.Password;

import edu.bu.met.cs665.Category.Category;
import edu.bu.met.cs665.EncryptionAlgorithms.EncryptionAlgorithm;
import edu.bu.met.cs665.PasswordManager;

import java.util.List;

public class Password implements Observer {
    private String website;
    private String username;
    private String encryptedPassword;
    private EncryptionAlgorithm encryptionAlgorithm;
    private Category category;

    public Password(String website, String username, String encryptedPassword, EncryptionAlgorithm encryptionAlgorithm, Category category) {
        this.website = website;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.encryptionAlgorithm = encryptionAlgorithm;
        this.category = category;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }
    public Category getCategory() {
        return category;
    }

    @Override
    public void update() {
        // implementation for updating the Password object
        List<Password> passwords = PasswordManager.getInstance().getPasswords();
        // update the Password object if it exists in the PasswordManager
        for (Password password : passwords) {
            if (password.website.equals(this.website) && password.username.equals(this.username)) {
                this.encryptedPassword = password.getEncryptedPassword();
                this.encryptionAlgorithm = password.getEncryptionAlgorithm();
                this.category = password.getCategory();
            }
        }
        System.out.println("Password for " + this.website + "(website) and " + this.username + "(username) is: " + this.encryptedPassword + "(encrypted with " + this.encryptionAlgorithm.getName() + ")");
        System.out.println("Category \"" + this.getCategory().getName() +"\": ");
        System.out.println("Description: " + this.getCategory().getDescription());
        System.out.println("Color: " + this.getCategory().getColor());
        System.out.println(" ");


    }
}
