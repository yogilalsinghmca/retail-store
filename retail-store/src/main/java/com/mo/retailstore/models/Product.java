package com.mo.retailstore.models;

public  class Product {
    private String name;
    private String description;
    private Double price;
    private Integer id;
    private String type;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
   
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode() + price.hashCode() + id.intValue() + type.hashCode();
    }
    
    @Override
    public boolean equals(Object o){
        Product other = (Product)o;
        if(other == this){
            return true;
        }
        if(!this.name.equals(other.getName())){
            return false;
        }
        if(!this.id.equals(other.getId())){
            return false;
        }
        if(!this.type.equals(other.getType())){
            return false;
        }
        return true;
    }
    public void setType(String type) {
        this.type =type;
    }
}
