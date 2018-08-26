package com.mo.retailstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mo.retailstore.models.Product;
import com.mo.retailstore.services.InvoiceService;

@RestController
public class ProductScanController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/products")
    public ResponseEntity<String> scanProduct(@RequestBody Product entity) {
        if (invoiceService.scanProduct(entity)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
