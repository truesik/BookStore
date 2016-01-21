package ru.truesik.bookstore.model;

/**
 * Created by truesik on 21.01.2016.
 */
public class Category {
    private long id;
    private String categoryDescription;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Id: " + id +
                ", Category Description: \"" + categoryDescription + '\"' +
                '}';
    }
}
