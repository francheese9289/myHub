package main.java.com.griz.houseProjects.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

//Importing project constructor
import main.java.com.griz.houseProjects.model.Project;

public class databaseService {
    private static final String URL = "jdbc:postgresql://localhost:5432/house_projects";
    private static final String USER = "pgAdmin4";
    private static final String PASSWORD = "mysqlpass";


// Connect to & initialize database
    public void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (Statement stmt = conn.createStatement()) {
                // Creating tables for projects
                stmt.execute("""
                    CREATE TABLE IF NOT EXISTS rooms (
                    room_id SERIAL PRIMARY KEY,
                    room_name VARCHAR(255) NOT NULL
                );


                CREATE TABLE IF NOT EXISTS projects (
                    project_id SERIAL PRIMARY KEY,
                    project_name VARCHAR(255) NOT NULL,
                    project_status VARCHAR(50),
                    project_estimated_cost DECIMAL(10,2),
                    project_start_date DATE,
                    project_completion_date DATE,
                    project_created_at TIMESTAMP,
                    project_room INTEGER,
                    foreign key (project_room) references rooms(room_id) 
                );

                create table if not exists tasks (
                    task_id SERIAL primary key,
                    task_name VARCHAR(255) not null,
                    task_notes VARCHAR(500),
                    task_due_date DATE,
                    task_priority VARCHAR(50),
                    task_est_time FLOAT(2),
                    task_person VARCHAR(50),
                    task_project INTEGER,
                    foreign key (task_project) references projects(project_id)	
                );

                Create table if not EXISTS materials (
                    material_id SERIAL PRIMARY KEY,
                    material_name VARCHAR(255) NOT NULL,
                    material_cost NUMERIC,
                    material_procured BOOLEAN,
                    material_project INTEGER,
                    FOREIGN KEY materials(material_project) REFERENCES projects(project_id)
                );
                """);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


// ENTERING A NEW PROJECT
    public void saveProject(Project project) {
        String sql = """
            INSERT INTO projects (name, status, estimated_cost, start_date, completion_date, project_created_at, project_room)
            VALUES (?, ?, ?, ?)
        """;
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, project.getName());
            pstmt.setString(2, project.getStatus());
            pstmt.setDouble(3, project.getEstimatedCost());
            pstmt.setDate(4, new java.sql.Date(project.getStartDate().getTime()));
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
};




// // Main class to demonstrate usage
// public class HouseProjectTracker {
//     private DatabaseService dbService;
//     private YNABService ynabService;
    
//     public HouseProjectTracker() {
//         dbService = new DatabaseService();
//         ynabService = new YNABService();
        
//         // Initialize database
//         dbService.initializeDatabase();
//     }
    
//     public void addNewProject(String name, double estimatedCost) {
//         // Create project
//         Project project = new Project(name, estimatedCost);
        
//         // Save to database
//         dbService.saveProject(project);
        
//         // Create YNAB transaction
//         String transactionId = ynabService.createExpense(name, estimatedCost);
        
//         System.out.println("Project created with YNAB transaction: " + transactionId);
//     }
    
//     public static void main(String[] args) {
//         HouseProjectTracker tracker = new HouseProjectTracker();
//         tracker.addNewProject("Paint Living Room", 500.00);
//     }
// }
