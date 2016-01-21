package ru.truesik.bookstore.model;

/**
 * Created by truesik on 21.01.2016.
 */
public class Author {
    private long id;
    private long bookId;
    private String firstName;
    private String lastName;

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id: " + id +
                ", Book id: " + bookId +
                ", First name: \"" + firstName + '\"' +
                ", Last name: \"" + lastName + '\"' +
                '}';
    }
}
