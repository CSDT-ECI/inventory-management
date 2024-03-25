package com.systelab.inventory.controller;

import com.systelab.inventory.model.Supplier;
import com.systelab.inventory.repository.SupplierRepository;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SupplierControllerTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierController supplierController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @After
    public void tearDown() {
        RequestContextHolder.resetRequestAttributes();
    }

    @Test
    public void testSaveSupplier() {
        Supplier supplierToSave = new Supplier();
        Supplier savedSupplier = new Supplier();
        savedSupplier.setId(1L);

        when(supplierRepository.save(supplierToSave)).thenReturn(savedSupplier);

        ResponseEntity<Supplier> responseEntity = supplierController.saveSupplier(supplierToSave);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedSupplier, responseEntity.getBody());
    }

    @Test
    public void testDeleteSupplier() {
        Long id = 1L;
        Supplier supplier = new Supplier();
        supplier.setId(id);

        when(supplierRepository.findById(id)).thenReturn(Optional.of(supplier));

        ResponseEntity<?> responseEntity = supplierController.deleteSupplier(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(supplierRepository, times(1)).delete(supplier);
    }

    @Test
    public void testExistSupplier() {
        Long id = 1L;
        Supplier supplier = new Supplier();
        supplier.setId(id);

        when(supplierRepository.findById(id)).thenReturn(Optional.of(supplier));

        ResponseEntity<?> responseEntity = supplierController.existSupplier(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateSupplier() {
        Long id = 1L;
        Supplier existingSupplier = new Supplier();
        existingSupplier.setId(id);
        Supplier updatedSupplier = new Supplier();

        when(supplierRepository.findById(id)).thenReturn(Optional.of(existingSupplier));
        when(supplierRepository.save(updatedSupplier)).thenReturn(updatedSupplier);

        ResponseEntity<Supplier> responseEntity = supplierController.saveSupplier(id, updatedSupplier);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(updatedSupplier, responseEntity.getBody());
    }
}