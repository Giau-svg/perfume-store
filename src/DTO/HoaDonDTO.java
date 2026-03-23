/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class HoaDonDTO {

    private int id, customer_id, employee_id;
    private String employeeName, customerName;
    private double total;
    private Timestamp issue_date;

    public HoaDonDTO(int id, String employeeName, String customerName, Timestamp issue_date, double total) {
        this.id = id;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.total = total;
        this.issue_date = issue_date;
    }

    public HoaDonDTO(int id, int customer_id, int employee_id, String employeeName, String customerName, Timestamp issue_date, double total) {
        this.id = id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.total = total;
        this.issue_date = issue_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getIssueDate() {
        return issue_date;
    }

    public void setIssueDate(Timestamp issue_date) {
        this.issue_date = issue_date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String supplierName) {
        this.employeeName = supplierName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
