package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LenderTest {
    @Test
    void testAvailableFunds(){
        Lender lender=new Lender();
        assertEquals(5000.0,lender.availableFunds());
    }

    @Test
    void testDepositFunds(){
        Lender lender=new Lender();
        assertEquals(6000.0,lender.depositFunds(1000.00));
    }

}

