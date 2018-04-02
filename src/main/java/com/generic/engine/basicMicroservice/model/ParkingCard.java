package com.generic.engine.basicMicroservice.model;

import org.springframework.stereotype.Component;

@Component
public class ParkingCard {
    int slot;
    String color;
    UserDetails usd;
    ParkingCard(UserDetails usd){ 
        //Spring 4.3 dependency injection without @Autowire
        this.usd=usd;
    }
    public int getSlot() {
        return slot;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
}
