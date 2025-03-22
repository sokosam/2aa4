package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;

public class GridScan extends Algorithm {

    private final Drone drone;
    private JSONObject prevResult;
    private int steps;
    public Map map;
    private ScanState state;
    // private FindMapSize findMapSize;
    // private UndoPrevRight srcurr;

    // private enum ForceTurn {
    // NONE,
    // LEFT,
    // RIGHT,
    // FORWARD
    // }

    // private enum FindMapSize {
    // X1,
    // Y1,
    // X2,
    // Y2
    // }

    // private enum UndoPrevRight {
    // RIGHT1,
    // FORWARD1,
    // RIGHT2,
    // FORWARD2,
    // RIGHT3,
    // RIGHT4,
    // END
    // }

    // private ForceTurn turn;
    //
    public GridScan(Drone drone) {
        // this.turn = ForceTurn.NONE;
        this.drone = drone;
        this.steps = 0;
        this.map = new Map();
        this.state = new ScanState();
        this.prevResult = null;
        // this.findMapSize = FindMapSize.X1;
        // this.srcurr = UndoPrevRight.END;
    }

    public JSONObject makeDecision() {
        if (this.drone.getBatteryLevel() < 30) {
            return Actions.stop();
        }

        JSONObject decision = null;
        ScanState.states currentState = this.state.getState();
        switch (currentState) {
            case HORIZONTAL:
                decision = HorizontalScan.stateControl(this.map, this.drone, this.prevResult, this.state, this.steps);
                break;
            case TRANSITION1:
                decision = Actions.turnRight(this.drone);
                this.state.setState(ScanState.states.VERTICAL);
                this.steps = -1;
                break;
            case VERTICAL:
                decision = VerticalScan.stateControl(this.map, this.drone, this.prevResult, this.state, this.steps);
                break;
        }
        this.steps++;
        return decision;
        // if (this.srcurr != UndoPrevRight.END) {
        // if (this.map.getY1() == 0) {
        // return subtleRight(ForceTurn.RIGHT);
        // }
        // return subtleRight(ForceTurn.NONE);
        // }

        // if (this.findMapSize == FindMapSize.X1) {
        // if (this.steps % 2 == 0) {
        // this.steps++;
        // return Actions.echoRight(this.drone);
        // } else {
        // this.steps++;
        // if (prevResult != null && !prevResult.isEmpty() && prevResult.has("found")
        // && "GROUND".equals(prevResult.getString("found"))) {
        // this.findMapSize = FindMapSize.Y1;
        // this.map.setX1(this.drone.getxCoord());
        // this.srcurr = UndoPrevRight.RIGHT1;
        // return subtleRight(ForceTurn.RIGHT);
        // } else {
        // return Actions.flyForward(this.drone);
        // }
        // }
        // }

        // return null;
    }

    // private JSONObject subtleRight(ForceTurn turn) {
    // UndoPrevRight current = this.srcurr;
    // switch (current) {
    // case RIGHT1:
    // this.srcurr = UndoPrevRight.FORWARD1;
    // return Actions.turnRight(this.drone);
    // case FORWARD1:
    // this.srcurr = UndoPrevRight.RIGHT2;
    // return Actions.flyForward(this.drone);
    // case RIGHT2:
    // this.srcurr = UndoPrevRight.FORWARD2;
    // return Actions.turnRight(this.drone);
    // case FORWARD2:
    // this.srcurr = UndoPrevRight.RIGHT3;
    // return Actions.flyForward(this.drone);
    // case RIGHT3:
    // this.srcurr = UndoPrevRight.RIGHT4;
    // return Actions.turnRight(this.drone);
    // case RIGHT4:
    // this.srcurr = UndoPrevRight.END;
    // this.turn = turn;
    // return Actions.turnRight(this.drone);
    // default:
    // return null;
    // }
    // }

    public void setResult(JSONObject result) {
        this.prevResult = result;
    }

}
