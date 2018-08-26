package com.mo.retailstore.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import com.mo.retailstore.interfaces.Invoice;
import com.mo.retailstore.models.Product;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {

    @InjectMocks
    RetailStoreRepository repository;

    @Test
    public void shouldScanProduct() {

        Product product = new Product();
        product.setName("Soap");
        product.setId(2);
        product.setPrice(200d);
        product.setType("TypeB");
        product.setDescription("bath soap");

        boolean isScanned = repository.ScanProduct(product);
        assertTrue("not able to scan product", isScanned);
    }

    @Test
    public void shouldGenerateInvoice() {
        Product product = new Product();
        product.setName("Soap");
        product.setId(2);
        product.setPrice(200d);
        product.setType("TypeB");
        product.setDescription("bath soap");

        Product productA = new Product();
        productA.setName("Oil");
        productA.setId(1);
        productA.setPrice(100d);
        productA.setType("TypeA");
        productA.setDescription("Vegitable oil");
        boolean isScanned = repository.ScanProduct(product);
        boolean isScannedA = repository.ScanProduct(productA);
        assertTrue("not able to scan product", isScanned);
        assertTrue("not able to scan product", isScannedA);
        Invoice invoice = repository.generateInvoice();

        assertEquals(new Double(350d), invoice.getTotalCost());
        assertEquals(new Double(50d), invoice.getTotalSaleTax());
        assertNotNull("failed to generate invoice, its null", invoice);
    }
}
