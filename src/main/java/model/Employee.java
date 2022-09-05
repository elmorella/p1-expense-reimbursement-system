package model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", nullable = false)
    private int empId;
    private String name;
    private String email;
    private String password;
    private String title;

    public Employee() {}

    public Employee(String name, String email, String password, String title) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId = " + empId +
                ", name = '" + name + '\'' +
                ", email = '" + email + '\'' +
                ", title = '" + title + '\'' +
                '}';
    }
}
