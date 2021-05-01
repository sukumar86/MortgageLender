package com.cognizant;

import java.util.ArrayList;
import java.util.List;

public class Lender {
    private double availableFunds=5000;
    private double amount;
    private double totalFunds=5000;//Initial Amount of the Lender
    private List<Customer> custLst = new ArrayList<>();
    private String qualification;
    private String status;
    private double loanAmount;

    public double availableFunds() {

       return availableFunds;
    }

    public double depositFunds(double amount) {
        availableFunds = availableFunds + amount;
        totalFunds = totalFunds + amount;
        return availableFunds;
    }

    public void addCustomer(Customer customer) {
        custLst.add(customer);
    }

    public String evaluateLoanApplication(Customer customer) {
        //qualify
       double dti=  customer.getDti();
       int ccScore = customer.getCreditScore();
       double savAmt = customer.getSavingsAmt();
       double reqAmt = customer.getRequestedAmount();
       double qualifyAmt= reqAmt * 0.25;
       double partialQualAmt = savAmt * 4;

       if(dti < 36 && ccScore > 620 )
       {
           //Full qualification
          if(savAmt >= qualifyAmt){
               qualification = "qualified";
               loanAmount = qualifyAmt;
               status = "qualified";

               System.out.println("qualification: "+qualification);
         }else{
              qualification = "partially qualified";
              loanAmount = partialQualAmt;
              status = "qualified";
          }

       }else{
           qualification = "not qualified";
           loanAmount = 0;
           status = "denied";
       }
       customer.setQualification(qualification);
       customer.setLoanAmt(loanAmount);
       customer.setStatus(status);
       custLst.add(customer);
       return status;
    }

}
