package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;

public class GridScan extends Algorithm {

    private final Drone drone;
    private JSONObject prevResult;
    private int steps;

    private enum Turn {
        NONE,
        LEFT,
        RIGHT
    }

    private Turn turn;

    public GridScan(Drone drone) {
        this.turn = Turn.NONE;
        this.drone = drone;
        this.steps = 0;
    }

    public JSONObject makeDecision() {
        // System.out.println(this.prevResult);
        if (prevResult != null && !prevResult.isEmpty() && prevResult.has("found")
                && "OUT_OF_RANGE".equals(prevResult.getString("found"))) {

            // Nested if-statement for "range"
            if (prevResult.has("range") &&
                    prevResult.getInt("range") == 1) {

                if (drone.getDirection() == Direction.E) {
                    this.turn = Turn.RIGHT;
                    return Actions.turnRight(drone);
                } else {
                    this.turn = Turn.LEFT;
                    return Actions.turnLeft(drone);
                }
            }
        }
        if (this.turn == Turn.RIGHT) {
            this.turn = Turn.NONE;
            return Actions.turnRight(drone);
        } else if (this.turn == Turn.LEFT) {
            this.turn = Turn.NONE;
            return Actions.turnLeft(drone);
        }
        if (this.steps % 3 == 0) {
            this.steps++;
            return Actions.scan();
        } else if (this.steps % 2 == 0) {
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
