/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: EncryptionAlgorithm.java
 * Description: EncryptionAlgorithm interface
 */
package edu.bu.met.cs665.EncryptionAlgorithms;

public interface EncryptionAlgorithm {
    String getName();

    String encrypt(String password);

    String decrypt(String encryptedPassword);

}