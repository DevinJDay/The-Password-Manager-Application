/**
 * Name: Jie Dai
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/04/2023
 * File Name: CategoryBuilder.java
 * Description: Builder implementation
 */
package edu.bu.met.cs665.Category;

public class CategoryBuilder {
    private String name;
    private String description;
    private String color;

    public CategoryBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public CategoryBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Category build() {
        return new Category(name, description, color);
    }
}




