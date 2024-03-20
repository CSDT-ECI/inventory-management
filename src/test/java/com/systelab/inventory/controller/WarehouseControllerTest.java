package com.systelab.inventory.controller;

import com.systelab.inventory.model.Warehouse;
import com.systelab.inventory.repository.WarehouseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WarehouseControllerTest {

    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseController warehouseController;

    @Before
    public void setup() {
        // Mock data setup
        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(new Warehouse());
        warehouses.add(new Warehouse());

        Page<Warehouse> warehousePage = new PageImpl<>(warehouses);

        when(warehouseRepository.findAll()).thenReturn(warehouses);
        when(warehouseRepository.findAll(any(Pageable.class))).thenReturn(warehousePage);
    }

    @Test
    public void testGenerateWarehousesReport() {
        List<Warehouse> result = warehouseController.generateWarehousesReport();

        // Verify that the repository method was called
        verify(warehouseRepository, times(1)).findAll();

        // Verify that the returned list size is as expected
        assertEquals(2, result.size());
    }

    @Test
    public void testSubstitution() {
        ArgumentCaptor<Pageable> argumentCaptor = ArgumentCaptor.forClass(Pageable.class);

        Page<Warehouse> result = warehouseController.substition(PageRequest.of(0, 10));

        verify(warehouseRepository, times(1)).findAll(argumentCaptor.capture());

        Pageable capturedPageable = argumentCaptor.getValue();
        assertNotNull(capturedPageable);
        assertEquals(0, capturedPageable.getPageNumber());
        assertEquals(10, capturedPageable.getPageSize());

        assertEquals(2, result.getNumberOfElements());
    }
}