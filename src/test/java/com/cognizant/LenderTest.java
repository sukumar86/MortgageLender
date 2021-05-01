package com.cognizant;

import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LenderTest {
    @Test
    void testAvailableFunds(){
        Lender lender=new Lender();
        lender.setAvailableFunds(5000);
        assertEquals(5000.0,lender.getAvailableFunds());
    }

    @Test
    void testDepositFunds(){
        Lender lender=new Lender();
        lender.setTotalFunds(5000);
        lender.setAvailableFunds(5000);
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
    @Test
    void testApproveLoan(){
        Lender lender=new Lender();
        lender.setAvailableFunds(500000);
        Customer customer = new Customer(1001,250000,25,700,100000);
        //customer.setStatus("qualified");
        lender.evaluateLoanApplication(customer);
        Loan loan =new Loan(1001,250000,"approved");
        assertEquals("Loan approved",lender.approveLoan(loan, customer));
    }

    @Test
    void testOnHoldLoan(){
        Lender lender=new Lender();
        lender.setAvailableFunds(200000);
        Customer customer = new Customer(1001,250000,25,700,100000);
        //customer.setStatus("qualified");
        lender.evaluateLoanApplication(customer);
        Loan loan =new Loan(1001,250000,"on hold");
        assertEquals("Loan is on hold",lender.approveLoan(loan, customer));
    }

    @Test
    void testDeniedLoan(){
        Lender lender=new Lender();
        lender.setAvailableFunds(500000);
        Customer customer = new Customer(1001,250000,40,600,100000);
        //customer.setStatus("qualified");
        lender.evaluateLoanApplication(customer);
        Loan loan =new Loan(1001,0,"denied");
        assertEquals("Customer is not qualified for the Loan",lender.approveLoan(loan, customer));
    }
    @Test
    void testPendingFunds(){
        Lender lender=new Lender();
        lender.setAvailableFunds(500000);
        Customer customer = new Customer(1001,200000,25,700,100000);
        lender.evaluateLoanApplication(customer);
        Loan loan =new Loan(1001,200000,"approved");
        lender.approveLoan(loan, customer);
        assertEquals(200000,lender.getPendingFunds());
        assertEquals(300000,lender.getAvailableFunds());

    }
    @Test
    void testApproveLoanAcceptCase() {
        Lender lender = new Lender();
        lender.setAvailableFunds(500000);
        Customer customer = new Customer(1001, 200000, 25, 700, 100000);
        lender.evaluateLoanApplication(customer);
        Loan loan = new Loan(1001, 200000, "approved");
        lender.approveLoan(loan, customer);
        customer.setStatus("accepted");
        assertEquals("accepted", lender.disburseLoan(customer.getStatus(), loan));
    }
    @Test
    void testApproveLoanRejectCase() {
        Lender lender = new Lender();
        lender.setAvailableFunds(500000);
        Customer customer = new Customer(1001, 200000, 25, 700, 100000);
        lender.evaluateLoanApplication(customer);
        Loan loan = new Loan(1001, 200000, "approved");
        lender.approveLoan(loan, customer);
        assertEquals(300000,lender.getAvailableFunds());
        assertEquals(200000,lender.getPendingFunds());
        customer.setStatus("rejected");
        assertEquals("rejected", lender.disburseLoan(customer.getStatus(), loan));
        assertEquals(500000,lender.getAvailableFunds());
        assertEquals(0,lender.getPendingFunds());

    }

    @Test
    void testManageUndecidedLoan() throws ParseException {
        Lender lender=new Lender();
        lender.setAvailableFunds(500000);
        Customer customer = new Customer(1001,250000,25,700,100000);
       lender.evaluateLoanApplication(customer);
        Loan loan =new Loan(1001,250000,"approved");

        assertEquals("Loan approved",lender.approveLoan(loan, customer));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "25-04-2021 10:20:56";
        Date date = sdf.parse(dateInString);

        loan.setLoanApproveDate(date);
        assertEquals("expired", lender.manageExpireLoan(loan.getLoanApproveDate(),loan));
        assertEquals(500000,lender.getAvailableFunds());
        assertEquals(0,lender.getPendingFunds());
    }


}

