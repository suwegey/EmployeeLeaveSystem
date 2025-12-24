/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leave.model;

/**
 *
 * @author suweg
 */

public class Employee {

    protected int employeeId;
    protected String name;
    protected String email;
    protected String password;
    protected String department;
    protected String role;
    protected int leaveBalance;
    protected String profileImage;

    public Employee() {}

    // Getters & Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getLeaveBalance() { return leaveBalance; }
    public void setLeaveBalance(int leaveBalance) { this.leaveBalance = leaveBalance; }

    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
}

