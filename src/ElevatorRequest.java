public class ElevatorRequest {
    private int destFloor, currentFloor;

    public ElevatorRequest(int destFloor, int currentFloor) {
        this.destFloor = destFloor;
        this.currentFloor = currentFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
