package com.service.restservice.learning;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig
class LearningTest {

    private Learning subject;

    @BeforeEach
    public void setup(){
        subject = new Learning();
    }

    @Test
    public void testAdd(){
        int val = subject.add(1,2);
        assert val == 3;
    }

    @Test
    public void testAddSad(){
        int val = subject.add(1, -1);
        assert val == 0;
    }

    @Test
    public  void testAddMul(){
        int val = subject.addMul(0, 2);
        assert val == 6;
    }

    @Test
    public  void testAddMulWith1(){
        int val = subject.addMul(1, 2);
        assert val == 0;
    }

}