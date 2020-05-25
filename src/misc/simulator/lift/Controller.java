package misc.simulator.lift;

import java.util.PriorityQueue;

public class Controller {
    private Lift[] lifts;
    private int liftCount;
    private int floorCount;
    private float timePerFloor;
    private PriorityQueue<ControllerRequest> controllerRequestPriorityQueue;

    public static void main(String[] args) {
        new Controller(4, 10);
    }

    public Controller(int liftCount, int floorCount) {
        this.liftCount = liftCount;
        this.floorCount = floorCount;
        this.lifts = new Lift[liftCount];
        for (int i = 0; i < liftCount; i++) {
            lifts[i] = new Lift();
        }
        controllerRequestPriorityQueue = new PriorityQueue<>();
    }

    public void addRequest(int fromFloor, Direction towards){
        controllerRequestPriorityQueue.add(new ControllerRequest(fromFloor, towards));
    }
}
