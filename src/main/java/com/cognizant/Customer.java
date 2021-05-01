package com.cognizant;

public class Customer {
    private int custId;
    private double requestedAmount;
    private double dti;
    private int creditScore;
    private double savingsAmt;
    private double loanAmt;
    private String qualification;
    private String status;

    public Customer(int id, double reqAmt, double dti, int creditScore, double savAmt){
        this.custId = id;
        this.requestedAmount = reqAmt;
        this.dti = dti;
        this.creditScore = creditScore;
        this.savingsAmt = savAmt;
    }

    public int getCustId() {
        return custId;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }


    public double getDti() {
        return dti;
    }

    public int getCreditScore() {
        return creditScore;
    }


    public double getSavingsAmt() {
        return savingsAmt;
    }


    public double getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(double loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
