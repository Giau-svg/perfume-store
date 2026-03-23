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
public class PhieuNhapDTO {
    private int id;
    private String supplierName;
    private Timestamp import_date;
    private double total_cost;
    
    public PhieuNhapDTO(int id, String supplierName, Timestamp import_date, double total_cost) {
        this.id = id;
        this.supplierName = supplierName;
        this.import_date = import_date;
        this.total_cost = total_cost;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public Timestamp getImportDate() {
        return import_date;
    }

    public void setImportDate(Timestamp import_date) {
        this.import_date = import_date;
    }
    
    public double getTotalCost() {
        return total_cost;
    }

    public void setTotalCost(double total_cost) {
        this.total_cost = total_cost;
    }
}
