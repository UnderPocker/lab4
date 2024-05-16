package com.lab4;

public class ElevatorRequest{
    private final int destFloor, currentFloor, direction;

    public ElevatorRequest(int destFloor, int currentFloor) {
        this.destFloor = destFloor;
        this.currentFloor = currentFloor;
        direction = currentFloor < destFloor ? 1 : -1;
    }

    public int getDestFloor() {
        return destFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDirection() {
        return direction;
    }
}
