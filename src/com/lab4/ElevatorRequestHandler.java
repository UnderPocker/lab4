package com.lab4;

public class ElevatorRequestHandler {
    private final Elevator first, second;


    public ElevatorRequestHandler() {
        first = new Elevator("First");
        second = new Elevator("Second");

        first.start();
        second.start();
    }

    public void submitRequest(ElevatorRequest request){
        Elevator elevator = chooseAppropriate(request);
        elevator.submitRequest(request);
    }
    private Elevator chooseAppropriate(ElevatorRequest request){
        boolean isFree1 = first.getDirection().get() == 0,
                isFree2 = second.getDirection().get() == 0;

        int distance1 = getDistance(request, first), distance2 = getDistance(request, second);
        //кто то из лифтов свободен
        if (isFree1 && isFree2){
            return distance1 < distance2 ? first : second;
        }else if (isFree1){
            return second.getDirection().get() == request.getDirection() ? distance1 < distance2 ? first : second : first;
        }else if (isFree2){
            return first.getDirection().get() == request.getDirection() ? distance1 < distance2 ? first : second : first;
        }
        //кто то едет в нужном направлении
        else if (first.getDirection().get() == request.getDirection() && second.getDirection().get() == request.getDirection()){
            return distance1 < distance2 ? first : second;
        }else if (first.getDirection().get() == request.getDirection()){
            return first;
        }else if (second.getDirection().get() == request.getDirection()){
            return second;
        }
        //оба заняты
        return getDistance(request, first.getDestFloor().get()) < getDistance(request, second.getDestFloor().get()) ? first : second;
    }
    private int getDistance(ElevatorRequest request, Elevator elevator){
        return Math.abs(elevator.getCurrentFloor().get() - request.getCurrentFloor());
    }
    private int getDistance(ElevatorRequest request, int floor){
        return Math.abs(floor - request.getCurrentFloor());
    }

}
