package com.springboot.Rest.API.Model;

public class Receipt {
    private final double totalBill;

    public Receipt(double totalBill) {
        this.totalBill = totalBill;
    }

    /**
     * @return the totalBill
     */
    public double getTotalBill() {
        return totalBill;
    }
}
