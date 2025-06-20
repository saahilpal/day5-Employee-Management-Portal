package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mongo db = new mongo();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3.  delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                {
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String Empname = sc.nextLine();
                    System.out.print("Enter Employee Email: ");
                    String Email = sc.nextLine();
                    System.out.print("Enter Employee Skill: ");
                    String Skill = sc.nextLine();
                    System.out.print("Enter Employee Department: ");
                    String Department = sc.nextLine();
                    System.out.print("Enter Employee join date: ");
                    String joindate = sc.nextLine();


                    db.createEmployees(id, Empname, Email, Skill, Department, joindate);
                    break;
                }
                case 2:
                {
                    System.out.print("Enter the Employee ID to update: ");
                    int   id = sc.nextInt();
                    sc.nextLine();
                    String Empname = null, Email = null, Skill = null, Department = null;

                    while (true) {
                        System.out.println("\n--- Update Employee ---");
                        System.out.println("1. Update Employee Name");
                        System.out.println("2. Update Employee Email");
                        System.out.println("3. Update Employee Skill");
                        System.out.println("4. Update Employee Department");
                        System.out.println("5. Save Changes and Exit");
                        System.out.print("Enter your choice: ");
                        int updateChoice = sc.nextInt();
                        sc.nextLine();

                        switch (updateChoice) {
                            case 1:
                                System.out.print("Enter new Employee Name: ");
                                Empname = sc.nextLine();
                                break;

                            case 2:
                                System.out.print("Enter new Employee Email: ");
                                Email = sc.nextLine();
                                break;

                            case 3:
                                System.out.print("Enter new Employee Skill: ");
                                Skill = sc.nextLine();
                                break;

                            case 4:
                                System.out.print("Enter new Employee Department: ");
                                Department = sc.nextLine();
                                break;

                            case 5:

                                db.UpdateEmployees(id, Empname, Email, Skill, Department);
                                System.out.println("Employee information updated successfully.");
                                return;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                                  }

                }
                     case 3:

                {
                    System.out.print("Enter the Employee ID to Delete: ");
                    int   id = sc.nextInt();
                    sc.nextLine();
                    db.DeleteEmployee(id);
                }

                  case 4:
                  {
                      System.out.print("Enter the info to Search: ");
                      int   id = sc.nextInt();
                      sc.nextLine();
                      String Empname,



                      db.SearchEmployee(id,Empname,Email,Skill,Department,Joindate);
                  }
                }
            }

        }
    }



