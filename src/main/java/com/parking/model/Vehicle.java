package com.parking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {

    String registrationNumber;
    String color;
}
