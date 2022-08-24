package com.david.model;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthOfDate;
    private String identityCard;
    private int salary;
    private int employeeCategoryId;
    private boolean status;
    private boolean deleted;

    public Employee(int id, String firstName, String lastName, LocalDate birthOfDate, String identityCard, int salary, int employeeCategoryId, boolean status, boolean deleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
        this.identityCard = identityCard;
        this.salary = salary;
        this.employeeCategoryId = employeeCategoryId;
        this.status = status;
        this.deleted = deleted;
    }

    public Employee(String firstName, String lastName, LocalDate birthOfDate, String identityCard, int salary, int employeeCategoryId, boolean status, boolean deleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
        this.identityCard = identityCard;
        this.salary = salary;
        this.employeeCategoryId = employeeCategoryId;
        this.status = status;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public int getSalary() {
        return salary;
    }

    public int getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getStatusText() {
        String status = "aktív";
        if (!this.status) {
            status = "inaktív";
        }
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthOfDate=" + birthOfDate +
                ", identityCard='" + identityCard + '\'' +
                ", salary=" + salary +
                ", employeeCategoryId=" + employeeCategoryId +
                ", status=" + status +
                ", deleted=" + deleted +
                '}';
    }
}
