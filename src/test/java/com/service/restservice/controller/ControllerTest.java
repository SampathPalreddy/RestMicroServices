package com.service.restservice.controller;

import com.service.restservice.impl.ControllerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class ControllerTest {

    public Controller subject;

    @Mock
    public ControllerImpl controllerImpl;

    @BeforeEach
    void setUp() {
        subject  = new Controller(controllerImpl);
    }

    @Test
    void testGetAllCustomer() {
        int[] arr = {-10,12,-20,-8,15};
        boolean val = checkIfExist(arr);
    }
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> arrSet = new HashSet<>();
        for(int a: arr){
            if(arrSet.contains(2 * a) || (a%2 ==0 && arrSet.contains(a/2))) {
                return true;
            }
            arrSet.add(a);
        }
        return false;
    }

    @Test
    void testGetCustomer() {
        Mockito.when(controllerImpl.getCustomer(Mockito.anyInt())).thenReturn(Optional.empty());
        ResponseEntity<?> responseEntity = subject.getCustomer(1);
        assert responseEntity != null;

    }

    @Test
    void testSaveCustomer() {
    }

    @Test
    void testUpdateCustomer() {
    }
}