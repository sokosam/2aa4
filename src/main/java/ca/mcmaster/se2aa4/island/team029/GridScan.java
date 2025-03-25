package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONArray;
import org.json.JSONObject;

public class GridScan extends Algorithm {

    private final Drone drone;
    private JSONObject prevResult;
    private int steps;
    private Map map;
    private ScanState state;

    public GridScan(Drone drone) {
        this.drone = drone;
        this.steps = 0;
        this.map = new Map();
        this.state = new ScanState();
        this.prevResult = null;
    }

    @Override
    public JSONObject makeDecision() {
        if (this.drone.getBatteryLevel() < 30) {
            return Actions.stop();
        }

        // Checks if sites/creek is found

        if (prevResult != null) {

            if (prevResult.has("creeks")) {
                JSONArray creeks = prevResult.getJSONArray("creeks");
                for (int i = 0; i < creeks.length(); i++) {
                    map.addCreek(creeks.getString(i), drone.getxCoord(), drone.getyCoord());
                }
            }

            if (prevResult.has("sites")) {
                JSONArray sites = prevResult.getJSONArray("sites");
                for (int i = 0; i < sites.length(); i++) {
                    map.addEmergencySite(sites.getString(i), drone.getxCoord(), drone.getyCoord());
                }
            }

        }

        JSONObject decision = null;
        ScanState.states currentState = this.state.getState();

        // Switch statement for State Machine Control, to see the explaination of each
        // state, view ScanState.java
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
            case UPSHIFT:
                if (this.drone.getDirection() != Direction.N) {
                    decision = Actions.turnLeft(this.drone);
                } else {
                    if (this.drone.getyCoord() <= this.map.getY2() + 2) {
                        this.state.setState(ScanState.states.LEFTSHIFT);
                    }
                    decision = Actions.flyForward(this.drone);
                }
                break;
            case LEFTSHIFT:
                if (this.drone.getDirection() != Direction.W) {
                    decision = Actions.turnLeft(this.drone);
                } else {
                    // Upshift and Leftshift currently have a bug if the map borders are too small
                    if (this.drone.getxCoord() <= this.map.getX2() + 1) {
                        this.state.setState(ScanState.states.LEFTPASS);
                        steps = -1;
                    }
                    decision = Actions.flyForward(this.drone);
                }
                break;
            case LEFTPASS:
                if (this.drone.getxCoord() == this.map.getX1()) {
                    this.state.setState(ScanState.states.L2R1);
                    if (this.drone.getyCoord() <= this.map.getY1()) {
                        this.state.setState(ScanState.states.SCANSHIFT1);
                    }
                    decision = Actions.scan();
                } else if (this.steps % 2 == 0) {
                    decision = Actions.scan();
                } else {
                    decision = Actions.flyForward(this.drone);
                }
                break;
            case L2R1:
                decision = Actions.turnRight(this.drone);
                this.state.setState(ScanState.states.L2R2);
                break;
            case L2R2:
                decision = Actions.turnRight(this.drone);
                this.state.setState(ScanState.states.RIGHTPASS);
                this.steps = -1;
                break;
            case RIGHTPASS:
                if (this.drone.getxCoord() == this.map.getX2()) {
                    this.state.setState(ScanState.states.R2L1);
                    if (this.drone.getyCoord() <= this.map.getY1()) {
                        this.state.setState(ScanState.states.SCANSHIFT1);
                    }
                    decision = Actions.scan();
                } else if (this.steps % 2 == 0) {
                    decision = Actions.scan();
                } else {
                    decision = Actions.flyForward(this.drone);
                }
                break;
            case R2L1:
                decision = Actions.turnLeft(this.drone);
                this.state.setState(ScanState.states.R2L2);

                break;
            case R2L2:
                decision = Actions.turnLeft(this.drone);
                this.state.setState(ScanState.states.LEFTPASS);
                this.steps = -1;
                break;

            case SCANSHIFT1:
                if (this.drone.getDirection() == Direction.W) {
                    decision = Actions.turnRight(this.drone);
                } else {
                    decision = Actions.turnLeft(this.drone);
                }
                this.state.setState(ScanState.states.SCANSHIFT2);
                break;
            case SCANSHIFT2:
                if (this.drone.getxCoord() <= this.map.getX1()) {
                    decision = Actions.turnLeft(this.drone);
                } else {
                    decision = Actions.turnRight(this.drone);
                }
                this.state.setState(ScanState.states.SCANSHIFT3);
                break;
            case SCANSHIFT3:
                if (this.drone.getxCoord() <= this.map.getX1()) {
                    decision = Actions.turnLeft(this.drone);
                } else {
                    decision = Actions.turnRight(this.drone);
                }
                this.state.setState(ScanState.states.SCANSHIFT4);
                break;
            case SCANSHIFT4:
                decision = Actions.flyForward(this.drone);
                this.state.setState(ScanState.states.SCANSHIFT5);
                break;
            case SCANSHIFT5:
                if (this.drone.getxCoord() <= this.map.getX1()) {
                    decision = Actions.turnLeft(this.drone);
                } else {
                    decision = Actions.turnRight(this.drone);
                }
                this.state.setState(ScanState.states.SCANSHIFT6);
                break;
            case SCANSHIFT6:
                decision = Actions.flyForward(this.drone);
                if (this.drone.getxCoord() <= this.map.getX1()) {
                    this.state.setState(ScanState.states.RIGHTPASS2);
                } else {
                    this.state.setState(ScanState.states.LEFTPASS2);
                }
                steps = -1;
                break;
            case RIGHTPASS2:
                if (this.drone.getxCoord() == this.map.getX2()) {
                    this.state.setState(ScanState.states.R2L3);
                    if (this.drone.getyCoord() >= this.map.getY2()) {
                        this.state.setState(ScanState.states.END);
                    }
                    decision = Actions.scan();
                } else if (this.steps % 2 == 0) {
                    decision = Actions.scan();
                } else {
                    decision = Actions.flyForward(this.drone);
                }
                break;
            case R2L3:
                decision = Actions.turnRight(this.drone);
                this.state.setState(ScanState.states.R2L4);
                break;
            case R2L4:
                decision = Actions.turnRight(this.drone);
                this.state.setState(ScanState.states.LEFTPASS2);
                this.steps = -1;
                break;
            case LEFTPASS2:
                if (this.drone.getxCoord() <= this.map.getX1()) {
                    this.state.setState(ScanState.states.L2R3);
                    if (this.drone.getyCoord() >= this.map.getY2()) {
                        this.state.setState(ScanState.states.END);
                    }
                    decision = Actions.scan();
                } else if (this.steps % 2 == 0) {
                    decision = Actions.scan();
                } else {
                    decision = Actions.flyForward(this.drone);
                }
                break;
            case L2R3:
                decision = Actions.turnLeft(this.drone);
                this.state.setState(ScanState.states.L2R4);
                break;
            case L2R4:
                decision = Actions.turnLeft(this.drone);
                this.state.setState(ScanState.states.RIGHTPASS2);
                this.steps = -1;
                break;
            case END:
                decision = Actions.stop();
                break;
            default:
                decision = Actions.stop();
                break;

        }
        this.steps++;
        return decision;
    }

    public void setResult(JSONObject result) {
        this.prevResult = result;
    }

    public Map getMap() {
        return this.map;
    }

}
