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

    @Test
    void testAcceptLoanApplication(){
       Lender lender=new Lender();
       Customer customer = new Customer(1001,200000,25,700,100000);
       lender.addCustomer(customer);
       assertEquals(1001, customer.getCustId());
    }
    @Test
    void testEvaluateLoanApplication(){
        Lender lender=new Lender();
        Customer customer = new Customer(1001,200000,25,700,100000);
        assertEquals("qualified", lender.evaluateLoanApplication(customer));

    }

}

