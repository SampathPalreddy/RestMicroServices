package com.biglots.tms.outbound.service;

import lombok.var;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class Testing1Test {

    public Testing1 testing1;

    @BeforeEach
    void setUp() {
        testing1 = new Testing1();
    }

    @Test
    void testingForResult(){

        var response = testing1.transform(Arrays.asList(
                "13/31/2007T03:32:12Z,abc,retret",
                "03/31/2007T03:32:12Z,abc,0.23",
                "03/31/2007T03:32:12Z,ABC,50",
                "02/12/2007T03:32:12Z,abcs,1000",
                "03/14/2007T03:32:12Z,ABC,10000",
                "02/31/2007T03:32:12Z,ABCd,100000",
                "12/01/2007T03:32:12Z,abcd,10000",
                "03/12/2007T03:32:12Z,aa,10"));
    System.out.print(response);
    }
}
