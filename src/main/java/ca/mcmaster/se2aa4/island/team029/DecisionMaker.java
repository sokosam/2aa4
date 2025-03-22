package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;

public class DecisionMaker extends Algorithm {

    private final Drone drone;
    private JSONObject prevResult; // stores the previous result like a FSM
    private int steps;

    public DecisionMaker(Drone drone) {
        this.drone = drone;
        this.prevResult = null;
        this.steps = 0;
    }

    public JSONObject makeDecision() { // Wont highlight if drone goes outta bounds or other error
        if (this.steps % 2 == 0) {
            this.steps++;
            return Actions.echoForward(this.drone);
        } else {
            this.steps++;
            return Actions.flyForward(this.drone);
        }

    }

    public void setResult(JSONObject result) {
        this.prevResult = result;
    }
}
