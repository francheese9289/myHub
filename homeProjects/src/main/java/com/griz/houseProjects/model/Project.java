package main.java.com.griz.houseProjects.model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

// BASIC PROJECT CLASS
// need to create classes for all other tables (rooms, materials, tasks)


// enter project data
public class Project {
    private int id;
    private String name;
    private String status;
    // private String roomId;
    private double estimatedCost;
    // private String ynabTransactionId;
    private Date startDate;
    private Date completionDate;

    // Constructor
    public Project(String name, double estimatedCost) {
        this.name = name;
        this.estimatedCost = estimatedCost;
        this.status = "PLANNED";
        this.startDate = new Date(id);
    };
    // Getters & setters
}

// Getter in Java: Getter returns the value (accessors), it returns the value of data type int, String, double, float, etc. For the program’s convenience, the getter starts with the word “get” followed by the variable name.

// Setter in Java: While Setter sets or updates the value (mutators). It sets the value for any variable used in a class’s programs. and starts with the word “set” followed by the variable name. 