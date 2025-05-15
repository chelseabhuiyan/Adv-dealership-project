package com.pluralsight.dealership;
/** Enum used in vehicletype **/

public enum VehicleType {
    CAR, TRUCK, SUV, VAN;

    public static VehicleType fromString(String type) {
        return VehicleType.valueOf(type.toUpperCase());
    }
}
