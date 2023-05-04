/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: Category.java
 * Description: Builder implementation
 */
package edu.bu.met.cs665.Category;



public class Category{
    private String name;
    private String description;
    private String color;

    public Category(String name, String description, String color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }


}
