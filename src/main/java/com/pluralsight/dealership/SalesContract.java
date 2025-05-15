package com.pluralsight.dealership;

public class SalesContract extends Contract {
    private static final double SALES_TAX = 0.05;
    private static final double RECORDING_FEE = 100;
    private static final double PROCESSING_UNDER_10000_FEE = 295;
    private static final double PROCESSING_OVER_10000_FEE = 495;

    private boolean financeOption;
    private double vehiclePrice;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(contractDate, customerName, customerEmail, vehicle);
        this.vehiclePrice = vehicle.getPrice();  // Use vehicle's price as vehiclePrice
        this.financeOption = financeOption;
    }

    public boolean getFinanceOption() {
        return financeOption;
    }

    public boolean setFinanceOption(boolean financeOption){
        this.financeOption = financeOption;
    }
    //Overrides return computed value for the total price
    @Override
    public double getTotalPrice() {
        double processingFee = (vehiclePrice < 10000) ? PROCESSING_UNDER_10000_FEE : PROCESSING_OVER_10000_FEE;
        double taxAmount = vehiclePrice * SALES_TAX;
        return vehiclePrice + taxAmount + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financeOption) return 0;  // No loan, so no monthly payment

        double totalPrice = getTotalPrice();
        double annualRate;
        int months;

        // Use the vehiclePrice to decide the loan terms
        if (vehiclePrice >= 10000) {
            annualRate = 0.0425;
            months = 48;  // 4 years
        } else {
            annualRate = 0.0525;
            months = 24;  // 2 years
        }

        double monthlyRate = annualRate / 12;
        return totalPrice * monthlyRate * Math.pow(1 + monthlyRate, months) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }
}
