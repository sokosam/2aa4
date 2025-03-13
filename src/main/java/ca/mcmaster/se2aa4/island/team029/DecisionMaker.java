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

        if (prevResult != null && !prevResult.isEmpty()
                && !prevResult.getJSONArray("biomes").getString(0).equals("OCEAN")) {
            return Actions.stop();
        }

        if (steps % 3 == 1) {
            this.steps += 1;
            return Actions.turnRight(drone);
        }
        if (steps % 3 == 2) {
            this.steps += 1;
            return Actions.turnLeft(drone);
        } else {
            this.steps += 1;
            return Actions.scan();
        }

    }

    public void setResult(JSONObject result) {
        this.prevResult = result;
    }
}
