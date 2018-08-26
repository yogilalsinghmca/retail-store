package com.mo.retailstore.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.mo.retailstore.enums.ProductType;
import com.mo.retailstore.interfaces.Invoice;
import com.mo.retailstore.models.Product;
import com.mo.retailstore.models.RetailInvoice;

@Repository
public class RetailStoreRepository {
    private Map<Product,Integer> productsMap = new HashMap<>();
    
    public boolean ScanProduct(Product product){
        if( product == null){
            return false;
        }
        if(productsMap.get(product) == null){
            productsMap.put(product, 1);
        } else {
            productsMap.put(product, productsMap.get(product) + 1);
        }
        return true;
    }
    
    public Invoice generateInvoice(){
        Invoice invoice = new RetailInvoice();
        invoice.setId(5000);
        invoice.setTotalCost(0d);
        getProductsMap().forEach((k,productCount) -> {
            Double currentProductCost = k.getPrice();
            invoice.setTotalCost(invoice.getTotalCost() + productCount*currentProductCost);
            Optional<ProductType> type = ProductType.getProductTypebyType(k.getType());
            Double saleTax = (k.getPrice()* type.get().getLevyRate());
            invoice.setTotalSaleTax(invoice.getTotalSaleTax() + saleTax*productCount);
        });
        // add total tax to total cost
        invoice.setTotalCost(invoice.getTotalCost() + invoice.getTotalSaleTax());
        return invoice;
    }

    public Map<Product, Integer> getProductsMap() {
        return productsMap;
    }
}
