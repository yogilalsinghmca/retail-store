package com.mo.retailstore.models;

import com.mo.retailstore.interfaces.Invoice;

public class RetailInvoice implements Invoice {
    private Integer id;
    private Double totalCost;
    private double totalSaleTax;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Double getTotalCost() {
        return totalCost;
    }

    @Override
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public Double getTotalSaleTax() {
        return totalSaleTax;
    }

    @Override
    public void setTotalSaleTax(Double totalSaleTax) {
        this.totalSaleTax = totalSaleTax;
    }
    @Override
    public boolean equals(Object o){
        Invoice other = (RetailInvoice)o;
        if(this.getId().equals(other.getId())){
            return true;
        }
        return false;
    }
}
