package org.example;

public class Employees {
    protected String Empname;
    protected String Email;
    protected String Skill;
    protected String Department;
    protected  String Joindate;
    protected  int Employeeid;
    public Employees(  int id,String Empname,String Email,String Skill,String Department,String Joindate)
    {
        this.Employeeid=id;
        this.Empname= Empname;
        this.Department=Department;
        this.Email=Email;
        this.Joindate =Joindate;
        this.Skill=Skill;

    }
     public String getEmpname()
     {
         return Empname;
     }
    public String getEmail()
    {
        return Email;
    }
    public String getSkill()
    {
        return Skill;
    }
    public String getDepartment()
    {
        return Department;
    }
    public String getJoindate()
    {
        return Joindate ;
    }

    public int getEmployeeid() {
        return Employeeid;
    }
}
