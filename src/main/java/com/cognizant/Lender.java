package com.cognizant;

public class Lender {
    private double availableFunds=5000;
    private double amount;
    private double totalFunds=5000;//Initial Amount of the Lender

    public double availableFunds() {

       return availableFunds;
    }

    public double depositFunds(double amount) {
        availableFunds = availableFunds + amount;
        totalFunds = totalFunds + amount;
        return availableFunds;
    }
}
