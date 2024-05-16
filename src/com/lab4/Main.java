package com.lab4;

public class Main {
    public static void main(String[] args) {
        ElevatorRequestHandler elevatorRequestHandler = new ElevatorRequestHandler();

        ElevatorRequest request1 = new ElevatorRequest(4, 8);
        ElevatorRequest request2 = new ElevatorRequest(9, 1);
        elevatorRequestHandler.submitRequest(request1);
        elevatorRequestHandler.submitRequest(request2);
    }
}
