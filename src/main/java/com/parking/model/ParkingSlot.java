package com.parking.model;

public class ParkingSlot {
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private int slotId;
    private Vehicle vehicle;

    @Override
    public String toString() {
        return new StringBuilder().append(slotId).append("\t").append(vehicle.getRegistrationNumber()).toString();
    }
}