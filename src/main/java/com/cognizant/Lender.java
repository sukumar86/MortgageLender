package com.cognizant;

import java.util.ArrayList;
import java.util.List;

public class Lender {
    private double availableFunds;
    private double amount;
    private double totalFunds;
    private List<Customer> custLst = new ArrayList<>();
    private String qualification;
    private String status;
    private double loanAmount;
    private double pendingFunds;

    public double getAvailableFunds() {

       return availableFunds;
    }

    public void setAvailableFunds(double availableFunds) {
        this.availableFunds = availableFunds;
    }

    public double depositFunds(double amount) {
        availableFunds = availableFunds + amount;
        totalFunds = totalFunds + amount;
        return availableFunds;
    }

    public double getTotalFunds() {
        return totalFunds;
    }

    public void setTotalFunds(double totalFunds) {
        this.totalFunds = totalFunds;
    }

    public double getPendingFunds() {
        return pendingFunds;
    }

    public void setPendingFunds(double pendingFunds) {
        this.pendingFunds = pendingFunds;
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
       addCustomer(customer);
       //custLst.add(customer);
//       for(int i=0; i< custLst.size(); i++){
//           Customer cust = custLst.get(i);
//           System.out.println(cust.getCustId());
//       }
       return status;
    }

    public String approveLoan(Loan loan,Customer customer) {
        double availFunds=getAvailableFunds();
        String message="";
        if(customer.getStatus().equals("qualified")) {

            if (availFunds > 0 && loan.getLoanAmt() < availFunds) {
                loan.setLoanStatus("approved");
                setPendingFunds(loan.getLoanAmt());
                availFunds = availFunds - loan.getLoanAmt();
                setAvailableFunds(availFunds);
                message="Loan approved";
            }else if (availFunds > 0 && loan.getLoanAmt() > availFunds) {
                    loan.setLoanStatus("on hold");
                    message="Loan is on hold";

            }

        } else{
            message ="Customer is not qualified for the Loan";
        }
        return message;
    }

    public String disburseLoan(String status,Loan loan) {
        if(status.equalsIgnoreCase("accepted")){
           setPendingFunds(getPendingFunds() - loan.getLoanAmt());
           loan.setLoanStatus("accepted");
        }else if(status.equalsIgnoreCase("rejected")){
            setPendingFunds(getPendingFunds() - loan.getLoanAmt());
            setAvailableFunds(getAvailableFunds() + loan.getLoanAmt());
            loan.setLoanStatus("rejected");
        }
            return loan.getLoanStatus();
    }
}
