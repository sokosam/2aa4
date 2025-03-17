package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;

public class DecisionMaker {

    private final Drone drone;
    private JSONObject prevResult; // stores the previous result like a FSM
    private int steps;

    public DecisionMaker(Drone drone) {
        this.drone = drone;
        this.prevResult = null;
        this.steps = 0;
    }

    public JSONObject makeDecision() { // Wont highlight if drone goes outta bounds or other error
        if (this.steps == 0) {
            this.steps = 1;
            return Actions.scan();
        } else if (this.steps == 1) {
            this.steps = 2;
            return Actions.turnRight(drone);
        } else if (this.steps == 2) {
            this.steps = 3;
            return Actions.scan();
        } else {
            this.steps = 0;
            return Actions.stop();
        }

    }

    public void setResult(JSONObject result) {
        this.prevResult = result;
    }
}
