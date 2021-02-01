package com.service.restservice.learning;

import org.springframework.stereotype.Component;

@Component
public class Learning {

    public int add(int a, int b){
        return a + b;
    }
    public int addMul(int a, int b){
        if(a == 1 && b == 2) {
            return 0;
        } else if(a == 1){
            return a + 2*b;
        }
        return 3*b;
    }

}
