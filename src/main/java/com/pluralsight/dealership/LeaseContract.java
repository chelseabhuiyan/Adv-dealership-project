package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private static final double LEASE_FEE_PERCENTAGE = 0.07; // 7% lease fee
    private static final double SALES_TAX = 0.05; // 5% sales tax
    private static final int LEASE_TERM = 36; // Lease term in months
    private static final double ENDING_VALUE_PERCENTAGE = 0.50; // 50% of the original price

    private double vehiclePrice;

    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        super(contractDate, customerName, customerEmail, vehicle);
        this.vehiclePrice = vehicle.getPrice();
    }

    // Overrides to return computed value for the total lease price
    @Override
    public double getTotalPrice() {
        double leaseFee = vehiclePrice * LEASE_FEE_PERCENTAGE;
        double taxAmount = vehiclePrice * SALES_TAX;
        double endingValue = vehiclePrice * ENDING_VALUE_PERCENTAGE;
        return vehiclePrice + leaseFee + taxAmount + endingValue; // Total cost includes lease fee, tax, and ending value
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double monthlyRate = 0.04 / 12; // 4% annual interest rate for leasing

        return totalPrice * monthlyRate * Math.pow(1 + monthlyRate, LEASE_TERM) /
                (Math.pow(1 + monthlyRate, LEASE_TERM) - 1); // Formula for monthly payment calculation
    }
}
