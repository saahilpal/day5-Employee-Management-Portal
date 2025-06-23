package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class mongo {

    private final MongoCollection<Document> Employees;

    public mongo() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase db = client.getDatabase("company");
        Employees = db.getCollection("employee");
    }

    public void createEmployees(int id, String Empname, String Email, String Skill, String Department, String Joindate) {
        if (Employees.find(eq("Employeeid ", id)).first() != null)
        {
            System.out.println("Account already exists.");
            return;
        }
        if (Empname == null || Email == null || Skill == null || Department == null || Joindate == null) {
            System.out.println("All fields are required. Please provide valid data.");
            return;
        }
        Document doc = new Document("Employeeid", id)
                .append("name", Empname)
                .append("Email", Email)
                .append("Department", Department)
                .append("Join Date", Joindate)
                .append("Skills", Skill);

        Employees.insertOne(doc);
        System.out.println("Employee  created.");
    }

    public void UpdateEmployees(int id, String empName, String email, String skill, String department) {
        Document doc = Employees.find(eq("Employeeid", id)).first();

        if (doc == null) {
            System.out.println("Account doesn't exist.");
            return;
        }

        Document updateFields = new Document();

        if (empName != null) updateFields.append("name", empName);
        if (email != null) updateFields.append("Email", email);
        if (department != null) updateFields.append("Department", department);
        if (skill != null) updateFields.append("Skills", skill);

        if (updateFields.isEmpty()) {
            System.out.println("No valid fields to update.");
            return;
        }

        Employees.updateOne(
                eq("Employeeid", id),
                new Document("$set", updateFields)
        );

        System.out.println("Account details updated.");
    }


    public void DeleteEmployee(int id) {
        Document doc = Employees.find(eq("Employeeid", id)).first();

        if (doc == null) {
            System.out.println("Account doesn't  exists.");
            return;
        }
        Employees.deleteMany(eq("Employeeid", id));
        System.out.println("Employee with ID " + id + " deleted successfully.");


    }

    public void searchEmployee(int id) {
        Document doc = Employees.find(eq("Employeeid", id)).first();

        if (doc == null) {
            System.out.println("Account doesn't exist.");
            return;
        }

        System.out.println("ID: " + doc.getInteger("Employeeid"));
        System.out.println("EmpName: " + doc.getString("Empname"));
        System.out.println("Email: " + doc.getString("Email"));
        System.out.println("Skill: " + doc.getString("Skills"));
        System.out.println("Department: " + doc.getString("Department"));
        System.out.println("Join Date: " + doc.getString("Joindate"));
    }

}
