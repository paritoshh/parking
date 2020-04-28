package com.parking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSlot {
    private int slotId;
    private Vehicle vehicle;
}