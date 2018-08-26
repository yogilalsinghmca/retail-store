package com.mo.retailstore.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.mo.retailstore.models.Product;
import com.mo.retailstore.models.RetailInvoice;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= RANDOM_PORT)

public class InvoiceControllerIntTest {
    @LocalServerPort
    private int port;
    
    @Autowired
    TestRestTemplate restTemplate;
    
    
    @Test
    public void shouldReturnInvoiceforProducts(){
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
        
        RetailInvoice retailInvoice = new RetailInvoice();
        retailInvoice.setTotalCost(350d);
        retailInvoice.setTotalSaleTax(50d);
        retailInvoice.setId(5000);
        restTemplate.postForEntity(createURLWithPort("/products"), product, String.class);
        restTemplate.postForEntity(createURLWithPort("/products"), productA, String.class);
        ResponseEntity<RetailInvoice> response =  restTemplate.getForEntity(createURLWithPort("/invoice"), RetailInvoice.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        
        assertThat(response.getBody(), is(retailInvoice));
        assertThat(response.getBody().getId(), is(retailInvoice.getId()));
        assertThat(response.getBody().getTotalCost(), is(retailInvoice.getTotalCost()));
        assertThat(response.getBody().getTotalSaleTax(), is(retailInvoice.getTotalSaleTax()));
    }
    
    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }
}
