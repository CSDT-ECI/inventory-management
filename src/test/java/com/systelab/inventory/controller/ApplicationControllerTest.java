package com.systelab.inventory.controller;




import com.systelab.inventory.controller.ApplicationController;
import com.systelab.inventory.service.ApplicationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationControllerTest {

    @Mock
    private ApplicationService applicationService;

    @InjectMocks
    private ApplicationController applicationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitSomeData_Success() {
        when(applicationService.initSomeData()).thenReturn(true);
        boolean result = applicationController.initSomeData();
        verify(applicationService, times(1)).initSomeData();
        assertTrue(result);
    }

    @Test
    public void testInitSomeData_Failure() {
        when(applicationService.initSomeData()).thenReturn(false);
        boolean result = applicationController.initSomeData();
        verify(applicationService, times(1)).initSomeData();
        assertFalse(result);
    }

    @Test(expected = NullPointerException.class)
    public void testInitSomeData_Exception() {
        when(applicationService.initSomeData()).thenThrow(new NullPointerException());
        applicationController.initSomeData();
        verify(applicationService, times(1)).initSomeData();
    }
}