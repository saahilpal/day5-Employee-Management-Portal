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
        if (Employees.find(eq("Employeeid ", id)).first() != null) {
            System.out.println("Account already exists.");
            return;
        }

        Document doc = new Document("Employeeid", id)
                .append("name", Empname)
                .append("Email", Email)
                .append(" Department", Department)
                .append(" Join Date", Joindate)
                .append(" Skills", Skill);

        Employees.insertOne(doc);
        System.out.println("Employee  created.");
    }

    public void UpdateEmployees(int id, String Empname, String Email, String Skill, String Department) {
        Document doc = Employees.find(eq("Employeeid", id)).first();

        if (doc == null) {
            System.out.println("Account Doesn't  exists.");
            return;
        }

        Employees.updateOne(
                eq("Employeeid", id),
                new Document("$set", new Document("Employee name", Empname)
                        .append("Email", Email)
                        .append("Department", Department)
                        .append("Skills", Skill)
                )
        );

        System.out.println("Account  details updated ");


    }

    public void DeleteEmployee(int id) {
        Document doc = Employees.find(eq("Employeeid", id)).first();

        if (doc == null) {
            System.out.println("Account Doesn't  exists.");
            return;
        }
        Employees.deleteMany(eq("Employeeid", id));
        System.out.println("Employee with ID " + id + " deleted successfully.");


    }

    public void SearchEmployee(int id, String Empname, String Email, String Skill, String Department,String Joindate)
    {
        Document doc = Employees.find(eq("Employeeid", id)).first();
        if (doc ==null)
        {
            System.out.println("Account Doesn't exists.");
            return;
        }
        else {
            System.out.println("ID: " + doc.getInteger("Employeeid"));
            System.out.println("Empname: " + doc.getString("Empname"));
            System.out.println("Email: " + doc.getString("Email"));
            System.out.println("Skill: " + doc.getString("Skill"));
            System.out.println("Department: " + doc.getString("Department"));
            System.out.println("Joindate: " + doc.getString("Joindate"));

        }

    }

}
