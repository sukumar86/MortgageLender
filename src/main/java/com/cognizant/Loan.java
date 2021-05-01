package com.cognizant;

public class Loan {
    private int custId;
    private double loanAmt;
    private String loanStatus;

    public Loan(int custId, double loanAmt, String loanStatus) {
        this.custId = custId;
        this.loanAmt = loanAmt;
        this.loanStatus = loanStatus;
    }

    public int getCustId() {
        return custId;
    }

    public double getLoanAmt() {
        return loanAmt;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}
