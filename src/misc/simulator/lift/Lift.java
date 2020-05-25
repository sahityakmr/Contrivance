package misc.simulator.lift;

public class Lift {
    private int currentFloor;
    private boolean isOperational;
    private Direction direction;

    public Lift() {
        currentFloor = 0;
        isOperational = true;
        direction = Direction.NEUTRAL;
    }
}
