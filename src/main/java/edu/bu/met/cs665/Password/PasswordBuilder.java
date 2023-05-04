/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: PasswordBuilder.java
 * Description: Builder implementation
 */
package edu.bu.met.cs665.Password;

import edu.bu.met.cs665.EncryptionAlgorithms.EncryptionAlgorithm;
import edu.bu.met.cs665.Category.Category;

public class PasswordBuilder {
    private String website;
    private String username;
    private String encryptedPassword;
    private EncryptionAlgorithm encryptionAlgorithm;
    private Category category;

    public PasswordBuilder setWebsite(String website) {
        this.website = website;
        return this;
    }

    public PasswordBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public PasswordBuilder setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        return this;
    }

    public PasswordBuilder setEncryptionAlgorithm(EncryptionAlgorithm algorithm) {
        this.encryptionAlgorithm = algorithm;
        return this;
    }

    public PasswordBuilder setCategory(Category category){
        this.category = category;
        return this;
    }

    public Password build() {
        return new Password(website, username, encryptedPassword, encryptionAlgorithm, category);
    }
}
