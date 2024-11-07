package main.java.com.griz.houseProjects.config;

// Configure database connection

public class databaseConfig {
    private static final String URL ="jdbc:postgresql://localhost:5432/house_projects";
    private static final String User = "${db.user}";
    public static final String Password = "{$://}";

    public static String getUrl() { return URL; }
    public static String getUser() { return User; }
    public static String getPassword () { return Password; }
}


