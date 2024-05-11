import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Elevator {
    private AtomicInteger currentFloor, destFloor;
    private ReentrantLock lock;


    private void moveNextFlor() throws InterruptedException {
        currentFloor.incrementAndGet();
        Thread.sleep(2000);
    }
    private void acceptClient() throws InterruptedException {
        Thread.sleep(2000);

    }

    public AtomicInteger getCurrentFloor() {
        return currentFloor;
    }

    public AtomicInteger getDestFloor() {
        return destFloor;
    }

}
