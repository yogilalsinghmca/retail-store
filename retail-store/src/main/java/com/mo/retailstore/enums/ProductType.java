package com.mo.retailstore.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductType {

    PRODUCTA("TypeA",0.10d),
    PRODUCTB("TypeB",0.20d),
    PRODUCTC("TypeC",0.0d);
    
    private String type;
    private Double levyRate;
    private ProductType(String type, Double levyRate){
        this.type = type;
        this.levyRate = levyRate;
    }
    
    public String getType() {
        return type;
    }
    
    public Double getLevyRate() {
        return levyRate;
    }
    
    public static Optional<ProductType> getProductTypebyType(String type){
        return Arrays.stream(ProductType.values()).filter(aType -> aType.getType().equals(type)).findFirst();
    }
}
