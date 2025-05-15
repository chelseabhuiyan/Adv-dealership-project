package com.pluralsight.dealership;

// A Contract will hold information common to all contacts. It should be an
// abstract class as you can't create a generic contract.

public abstract class Contract {
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;


    public Contract(String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicle;
    }

    // Abstract methods for calculated values so they arent in private variables
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

    // Getters
    public String getContractDate() {
        return contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    // Setters
    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
