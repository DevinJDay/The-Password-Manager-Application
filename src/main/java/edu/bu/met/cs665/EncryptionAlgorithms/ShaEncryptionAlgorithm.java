/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: ShaEncryptionAlgorithm.java
 * Description: ShaEncryptionAlgorithm implementation
 */
package edu.bu.met.cs665.EncryptionAlgorithms;

public class ShaEncryptionAlgorithm implements EncryptionAlgorithm {

    @Override
    public String getName(){
        return "SHA";
    }

    @Override
    public String encrypt(String password) {
        // implementation of AES encryption algorithm
        return password;
    }

    @Override
    public String decrypt(String encryptedPassword) {
        // implementation of AES decryption algorithm
        return encryptedPassword;
    }
}
