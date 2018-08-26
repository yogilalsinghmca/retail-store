package com.mo.retailstore.interfaces;

public interface Invoice {
    public Integer getId();

    public void setId(Integer id);

    public Double getTotalCost();

    public void setTotalCost(Double totalCost);

    public Double getTotalSaleTax();

    public void setTotalSaleTax(Double totalSaleTax);
}
