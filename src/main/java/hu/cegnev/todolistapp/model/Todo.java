package hu.cegnev.todolistapp.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * To do model class to store the todo values.
 */
public class Todo {
    /**
     * The identifier to check item matches.
     */
    private int id;
    /**
     * The short title of the to do.
     */
    private String title;
    /**
     * The description of the to do that contains the details.
     */
    private String description;
    /**
     * You have to complete the to do until this time.
     */
    private DateTime deadLine;

    /**
     * Default constructor.
     */
    public Todo() {
    }

    /**
     * Full parameter constructor. Use it if you would like to set all the values in to do.
     *
     * @param id          the id of the to do
     * @param title       the title of the to do
     * @param description the description of the to do
     * @param deadLine    the deadline of the to do
     */
    public Todo(int id, String title, String description, DateTime deadLine) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
    }

    /**
     * This function returns the id of the to do.
     *
     * @return the id of the to do
     */
    public int getId() {
        return id;
    }

    /**
     * This function sets the id of the to do.
     *
     * @param id the id of the to do to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This function returns the title of the to do.
     *
     * @return the id of the to do
     */
    public String getTitle() {
        return title;
    }

    /**
     * This function sets the title of the to do.
     *
     * @param title the title of the to do to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This function returns the description of the to do.
     *
     * @return the description of the to do
     */
    public String getDescription() {
        return description;
    }

    /**
     * This function sets the description of the to do.
     *
     * @param description the description of the to do to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This function returns the deadline of the to do.
     *
     * @return the deadline of the to do
     */
    public DateTime getDeadLine() {
        return deadLine;
    }

    /**
     * This function sets the deadline of the to do.
     *
     * @param deadLine the deadline of the to do to set
     */
    public void setDeadLine(DateTime deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "\n========================================\n\nId: " + id + "\nTitle: " + title + "\nDescription: "
                + description + "\ndeadline: " + DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(deadLine)
                + "\n\n========================================";
    }

}
