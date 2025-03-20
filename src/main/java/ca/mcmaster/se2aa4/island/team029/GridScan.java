package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;

public class GridScan extends Algorithm {

    private final Drone drone;
    private JSONObject prevResult;
    private int steps;
    private Map map;
    private FindMapSize findMapSize;
    private UndoPrevRight srcurr;

    private enum ForceTurn {
        NONE,
        LEFT,
        RIGHT,
        FORWARD
    }

    private enum FindMapSize {
        X1,
        Y1,
        X2,
        Y2
    }

    private enum UndoPrevRight {
        RIGHT1,
        FORWARD1,
        RIGHT2,
        FORWARD2,
        RIGHT3,
        RIGHT4,
        END
    }

    private ForceTurn turn;

    public GridScan(Drone drone) {
        this.turn = ForceTurn.NONE;
        this.drone = drone;
        this.steps = 0;
        this.map = new Map();
        this.findMapSize = FindMapSize.X1;
        this.srcurr = UndoPrevRight.END;
    }

    public JSONObject makeDecision() {
        if (this.drone.getBatteryLevel() < 30) {
            return Actions.stop();
        }

        if (this.srcurr != UndoPrevRight.END) {
            if (this.map.getY1() == 0) {
                return subtleRight(ForceTurn.RIGHT);
            }
            return subtleRight(ForceTurn.NONE);
        }

        if (this.findMapSize == FindMapSize.X1) {
            if (this.steps % 2 == 0) {
                this.steps++;
                return Actions.echoRight(this.drone);
            } else {
                this.steps++;
                if (prevResult != null && !prevResult.isEmpty() && prevResult.has("found")
                        && "GROUND".equals(prevResult.getString("found"))) {
                    this.findMapSize = FindMapSize.Y1;
                    this.map.setX1(this.drone.getxCoord());
                    this.srcurr = UndoPrevRight.RIGHT1;
                    return subtleRight(ForceTurn.RIGHT);
                } else {
                    return Actions.flyForward(this.drone);
                }
            }
        }

        return null;

        // if (map.getX1() == 0) {
        // if (this.srcurr != UndoPrevRight.END) {
        // return subtleRight(ForceTurn.RIGHT);
        // }
        // if (prevResult != null && !prevResult.isEmpty()){

        // }
        // }

        // if (steps > 3000) {
        // return Actions.stop();
        // }
        // // System.out.println(this.prevResult);
        // if (prevResult != null && !prevResult.isEmpty() && prevResult.has("found")
        // && "OUT_OF_RANGE".equals(prevResult.getString("found"))) {

        // // Nested if-statement for "range"
        // if (prevResult.has("range") &&
        // prevResult.getInt("range") == 1) {

        // if (drone.getDirection() == Direction.E) {
        // this.turn = Turn.RIGHT;
        // return Actions.turnRight(drone);
        // } else {
        // this.turn = Turn.LEFT;
        // return Actions.turnLeft(drone);
        // }
        // }
        // }
        // if (this.turn == Turn.RIGHT) {
        // this.turn = Turn.NONE;
        // return Actions.turnRight(drone);
        // } else if (this.turn == Turn.LEFT) {
        // this.turn = Turn.NONE;
        // return Actions.turnLeft(drone);
        // }
        // if (this.steps % 3 == 0) {
        // this.steps++;
        // return Actions.scan();
        // } else if (this.steps % 2 == 0) {
        // this.steps++;
        // return Actions.echoForward(this.drone);
        // } else {
        // this.steps++;
        // return Actions.flyForward(this.drone);
        // }

    }

    private JSONObject subtleRight(ForceTurn turn) {
        UndoPrevRight current = this.srcurr;
        switch (current) {
            case RIGHT1:
                this.srcurr = UndoPrevRight.FORWARD1;
                return Actions.turnRight(this.drone);
            case FORWARD1:
                this.srcurr = UndoPrevRight.RIGHT2;
                return Actions.flyForward(this.drone);
            case RIGHT2:
                this.srcurr = UndoPrevRight.FORWARD2;
                return Actions.turnRight(this.drone);
            case FORWARD2:
                this.srcurr = UndoPrevRight.RIGHT3;
                return Actions.flyForward(this.drone);
            case RIGHT3:
                this.srcurr = UndoPrevRight.RIGHT4;
                return Actions.turnRight(this.drone);
            case RIGHT4:
                this.srcurr = UndoPrevRight.END;
                this.turn = turn;
                return Actions.turnRight(this.drone);
            default:
                return null;
        }
    }

    public void setResult(JSONObject result) {
        this.prevResult = result;
    }

}
