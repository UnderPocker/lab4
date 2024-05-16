package com.lab4;

import java.util.concurrent.atomic.AtomicInteger;

public class Elevator extends Thread{
    private final AtomicInteger currentFloor, destFloor, direction;
    private final String name;

    public Elevator(String name) {
        currentFloor = new AtomicInteger(1);
        destFloor = new AtomicInteger(1);
        direction = new AtomicInteger(0);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()){
                while (direction.get() == 0){
                    Thread.sleep(10);
                }

                while (direction.get() != 0){
                    moveNextFlor();
                }

            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    public void submitRequest(ElevatorRequest request){
        //если свободен
        if (direction.get() == 0) {
            destFloor.set(request.getCurrentFloor());
            direction.set(currentFloor.get() < request.getCurrentFloor() ? 1 : -1);

            while (request.getCurrentFloor() != currentFloor.get()) {
                try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
            direction.set(request.getDirection());
            destFloor.set(request.getDestFloor());

        }
        //если в том же направлении
        else if ((direction.get() > 0 && destFloor.get() < request.getDestFloor()
                || direction.get() < 0 && destFloor.get() > request.getDestFloor())
                && direction.get() == request.getDirection())
            destFloor.set(request.getDestFloor());
        //если в другом направлении
        else if (direction.get() != request.getDirection()){
            while (direction.get() != 0 && direction.get() != request.getDirection()) {
                try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
            submitRequest(request);
        }

    }
    private void moveNextFlor() throws InterruptedException {
        int floor = currentFloor.addAndGet(direction.get());
        Thread.sleep(1000);
        System.out.println(name + ": moved to floor " + floor);

        if (currentFloor.get() == destFloor.get())
            direction.set(0);
    }
    public AtomicInteger getCurrentFloor() {
        return currentFloor;
    }

    public AtomicInteger getDestFloor() {
        return destFloor;
    }

    public AtomicInteger getDirection() {
        return direction;
    }
}
