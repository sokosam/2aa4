package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team029.ScanState.states;

public class VerticalScan {

    public static JSONObject stateControl(Map map, Drone drone, JSONObject prev, ScanState state, int step) {
        if (step % 3 == 0) {
            return Actions.echoRight(drone);
        } else if (step % 3 == 1) {
            if (prev != null && !prev.isEmpty()) {
                if (prev.has("found") && prev.get("found").equals("GROUND")) {
                    if (map.getY1() == 0) {
                        map.setY1(drone.getyCoord());
                    } else {
                        map.setY2(drone.getyCoord());
                    }
                }
            }
            return Actions.echoForward(drone);
        } else {
            if (prev != null && !prev.isEmpty()) {
                if (prev.has("found") && prev.get("found").equals("OUT_OF_RANGE") && prev.getInt("range") <= 4) {
                    state.setState(states.UPSHIFT);
                }
            }
            return Actions.flyForward(drone);
        }
    }
}
