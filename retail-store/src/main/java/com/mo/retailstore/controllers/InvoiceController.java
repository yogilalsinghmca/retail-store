package com.mo.retailstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mo.retailstore.interfaces.Invoice;
import com.mo.retailstore.services.InvoiceService;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoice")
    public Invoice getInvoice() {
        return invoiceService.generateInvoice();
    }
}
