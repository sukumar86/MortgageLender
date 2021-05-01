package com.cognizant;

import java.util.Date;

public class Loan {
    private int custId;
    private double loanAmt;
    private String loanStatus;
    private Date loanApproveDate;

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

    public Date getLoanApproveDate() {
        return loanApproveDate;
    }

    public void setLoanApproveDate(Date loanApproveDate) {
        this.loanApproveDate = loanApproveDate;
    }
}
