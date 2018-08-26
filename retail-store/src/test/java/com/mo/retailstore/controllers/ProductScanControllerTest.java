package com.mo.retailstore.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mo.retailstore.models.Product;
import com.mo.retailstore.services.InvoiceService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductScanController.class)
public class ProductScanControllerTest {
    
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    InvoiceService invoiceController;
    
    @Autowired
    ObjectMapper mapper;
    
    @Test
    public void shouldReturnSuccessForAddProductPostRequest() throws Exception{
        Product product = new Product();
        product.setName("Cake");
        product.setId(1);
        product.setDescription("chocolate cake");
        product.setPrice(100d);
        product.setType("TypeA");
        when(invoiceController.scanProduct(product)).thenReturn(true);
        
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(product))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                )
        .andExpect(status().isCreated()).andExpect(content().string("")).andReturn();
        
        verify(invoiceController).scanProduct(product);
    }
    
    @Test
    public void shouldReturnNoContentforProductPostRequest() throws JsonProcessingException, Exception{
        Product product = new Product();
        product.setName("Cake");
        product.setId(1);
        product.setDescription("chocolate cake");
        product.setPrice(100d);
        product.setType("TypeA");
        when(invoiceController.scanProduct(product)).thenReturn(false);
        
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(product))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                )
        .andExpect(status().isNoContent())
        .andExpect(content().string(""))
        .andReturn();
    }
}
