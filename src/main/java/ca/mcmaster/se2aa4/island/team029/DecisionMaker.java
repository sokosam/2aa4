package ca.mcmaster.se2aa4.island.team029;

import ca.mcmaster.se2aa4.island.team029.Actions.Actions;
import org.json.JSONObject;

public class DecisionMaker {

    private Drone drone;
    private JSONObject prevResult;
    private int steps;

    public DecisionMaker(Drone drone){
        this.drone = drone;
        this.prevResult = null;
        this.steps = 0;
    }

    public JSONObject makeDecision(){
        return Actions.flyForward();
    }

    public void setResult(JSONObject result){
        this.prevResult = result;
    }
}
