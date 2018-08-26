package com.mo.retailstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mo.retailstore.interfaces.Invoice;
import com.mo.retailstore.models.Product;
import com.mo.retailstore.repositories.RetailStoreRepository;

@Service
public class InvoiceService {
    
    @Autowired
    RetailStoreRepository repository;
    
    public Invoice generateInvoice() {
        return  repository.generateInvoice();
    }

    public Boolean scanProduct(Product product) {
        return repository.ScanProduct(product);
    }
}
