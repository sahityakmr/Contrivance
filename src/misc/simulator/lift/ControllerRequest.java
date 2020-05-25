package misc.simulator.lift;

public class ControllerRequest {
    private int fromFloor;
    private Direction toDirection;

    public ControllerRequest(int fromFloor, Direction toDirection) {
        this.fromFloor = fromFloor;
        this.toDirection = toDirection;
    }
}
