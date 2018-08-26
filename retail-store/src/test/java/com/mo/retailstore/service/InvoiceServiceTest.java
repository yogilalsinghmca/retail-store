package com.mo.retailstore.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.mo.retailstore.models.Product;
import com.mo.retailstore.repositories.RetailStoreRepository;
import com.mo.retailstore.services.InvoiceService;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

    @InjectMocks
    InvoiceService invoiceService;

    @Mock
    RetailStoreRepository retailStoreRepository;

    @Test
    public void shouldAddProductToRepository() {
        Product product = new Product();
        product.setName("Cake");
        product.setId(1);
        product.setDescription("chocolate cake");
        product.setPrice(100d);
        when(retailStoreRepository.ScanProduct(product)).thenReturn(true);
        boolean isScanned = invoiceService.scanProduct(product);
        verify(retailStoreRepository).ScanProduct(product);
        assertTrue(isScanned);
    }

    @Test
    public void scanProductShouldFail() {
        boolean isScanned = invoiceService.scanProduct(null);
        assertFalse(isScanned);
    }
}

